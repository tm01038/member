package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "c##test";
	private static final String PW = "test";
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static Connection conn;

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection open() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(URL, ID, PW);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		conn = null;
	}

	public static void main(String[] args) {
		Connection conn = open();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select l_num, l_lentdate, l_recdate,m_num,b_num from lent";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("l_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}

	}
}
