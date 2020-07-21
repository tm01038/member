package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.BookDAO;

public class BookDAOImpl implements BookDAO {
	
	public int insertBook(Map<String, Object> book) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "insert into book(b_num,b_title,b_author,sysdate,b_desc)";
			sql += " values(seq_book_b_num.nextval,?,?,sysdate,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.get("b_title").toString());
			ps.setString(2, book.get("b_author").toString());
			ps.setString(3, book.get("b_desc").toString());
			result = ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateBook(Map<String, Object> book) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "UPDATE book ";
			sql += "set b_title=?,";
			sql += "b_author=?,";
			sql += "b_desc=?";
			sql += "where b_num=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, book.get("b_title").toString());
			ps.setString(2, book.get("b_author").toString());
			ps.setString(3, book.get("b_desc").toString());
			ps.setInt(4, (int) book.get("b_num"));
			result = ps.executeUpdate();
			conn.rollback();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteBook(int bNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = "delete from book where b_num=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bNum);
			result = ps.executeUpdate();
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Map<String, Object>> selectBookList(Map<String, Object> book) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> bookList = new ArrayList<Map<String, Object>>();

		try {
			conn = Connector.open();
			String sql = "select b_num,b_title,b_author,b_credate,b_desc from book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("b_num", rs.getInt("b_num"));
				map.put("b_title", rs.getString("b_title"));
				map.put("b_author", rs.getString("b_author"));
				map.put("b_credate", rs.getString("b_credate"));
				map.put("b_desc", rs.getString("b_desc"));
				bookList.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return bookList;
	}

	public Map<String, Object> selectBook(int bNum) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Object> choiceBook = new HashMap<String, Object>();

		try {
			conn = Connector.open();
			String sql = "select b_num,B_TITLE,b_author,b_credate,b_desc from book where b_num= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				choiceBook.put("b_num", rs.getInt("b_num"));
				choiceBook.put("b_title", rs.getString("b_title"));
				choiceBook.put("b_author", rs.getString("b_author"));
				choiceBook.put("b_credate", rs.getString("b_credate"));
				choiceBook.put("b_desc", rs.getString("b_desc"));
				return choiceBook;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	

}
