package net.ihypo.db;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import net.ihypo.code.Code;

public class CodeDrive {
	public static Code getCode(long id){
		return null;
	}
	
	public static void addCode(Code code) throws ClassNotFoundException, SQLException{
		Statement statement = (Statement) new DBDrive().getConnection().createStatement();
		statement.execute("insert codelist values("
				+ code.getName() + "," + code.getTitle() + "," + code.getLang() + "," 
				+ code.getTimestamp() + "," + code.getContent() + ");");
	}
}
