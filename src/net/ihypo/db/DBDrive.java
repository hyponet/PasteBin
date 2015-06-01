package net.ihypo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDrive {
	private Connection connection;
	private String url = "jdbc:mysql://localhost/pastebin";
	private String user = "root";
	private String psw = "123";
	
	public DBDrive() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,user,psw);
	}
	
	public Connection getConnection(){
		return connection;
	}
}
