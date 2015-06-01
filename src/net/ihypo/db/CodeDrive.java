package net.ihypo.db;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import net.ihypo.code.Code;

public class CodeDrive {
	
	private static long nextId = -1;
	
	public static Code getCode(long id) throws ClassNotFoundException, SQLException, UnsupportedEncodingException{
		
		Statement statement = (Statement) new DBDrive().getConnection().createStatement();
		
		ResultSet set = statement.executeQuery("select * from code where code_id = " + id + ";");
		if(set.next()){
			String name = new String(set.getBytes("code_poster"),"UTF-8");
			String title = new String(set.getString("code_title").getBytes("ISO-8859-1"),"UTF-8");
			String lang = new String(set.getString("code_lang").getBytes("ISO-8859-1"),"UTF-8");
			String content = new String(set.getString("code_content").getBytes("ISO-8859-1"),"UTF-8");
			Code code = new Code(name, title, lang, content);
			code.setId(set.getLong("code_id"));
			code.setTime(set.getTimestamp("code_time"));
			return code;
		}
		return null;
	}
	
	public static void addCode(Code code) throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DBDrive().getConnection().createStatement();
		
		statement.execute("insert into code values(" + code.getId() + ",'"
				+ code.getName() + "','" + code.getTitle() + "','" + code.getLang() + "','" 
				+ code.getTimestamp() + "','" + code.getContent() + "');");
		nextId += 1;
	}
	
	public static long getNextId() throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DBDrive().getConnection().createStatement();
		
		if(nextId == -1){
			ResultSet set = statement.executeQuery("select max(code_id) from code");
			set.next();
			nextId = set.getLong("max(code_id)") + 1;
		}
		return nextId;
	}
}
