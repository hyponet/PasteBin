package net.ihypo.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import net.ihypo.code.Code;

public class text {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Code code = new Code("张三", "题目", "C++", "内容");
	CodeDrive.addCode(code);
}
}
