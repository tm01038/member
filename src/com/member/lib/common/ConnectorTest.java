package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorTest {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String ID = "c##test";
	private static final String PWD = "test";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static Connection coon = null;
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (coon == null) {
			try {
				coon = DriverManager.getConnection(URL, ID, PWD);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return coon;
	}
	public static void close() {
		if(coon!=null) {
			try {
				coon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
