package net.ihypo.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import net.ihypo.code.Code;

public class CodeDrive {
	
	private static long nextId = -1;
	
	public static Code getCode(long id) throws ClassNotFoundException, SQLException{
		
		Statement statement = (Statement) new DBDrive().getConnection().createStatement();
		
		ResultSet set = statement.executeQuery("select * from code where code_id = " + id + ";");
		if(set.next()){
			String name = set.getString("code_poster");
			String title = set.getString("code_title");
			String lang = set.getString("code_lang");
			String content = set.getString("code_content");
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
