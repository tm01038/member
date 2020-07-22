package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector2 {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String ID = "test";
	private static final String PW = "1234";
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection open() {
		try {
			return conn = DriverManager.getConnection(URL, ID, PW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}