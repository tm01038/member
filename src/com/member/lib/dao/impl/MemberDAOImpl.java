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
import com.member.lib.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {

	public int insertMember(Map<String, Object> member) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			String sql = "insert into member(m_num,m_name,m_id,m_pw,m_credate)\r\n"
					+ "values(seq_member_m_num.nextval,?,?,?,sysdate)";

			conn = Connector.open();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_id").toString());
			ps.setString(3, member.get("m_pw").toString());
			result = ps.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			Connector.close();
			ps = null;
			conn = null;
		}
		return 0;
	}

	public int updateMember(Map<String, Object> member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update member";
			sql += " set m_name=?,";
			sql += " m_pw=?,";
			sql += " m_id=?";
			sql += " where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_pw").toString());
			ps.setString(3, member.get("m_id").toString());
			ps.setInt(4, (int)member.get("m_num"));
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(int mNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = Connector.open();
			String sql = " delete from member where m_num= ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mNum);
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

	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		List<Map<String, Object>> memberList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Connector.open();
			String sql = "SELECT m_pw,m_num,m_name,m_id,m_credate FROM MEMBER ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("m_pw", rs.getString("m_pw"));
				map.put("m_num", rs.getInt("m_num"));
				map.put("m_name", rs.getString("m_name"));
				map.put("m_id", rs.getString("m_id"));
				map.put("m_credate", rs.getString("m_credate"));
				memberList.add(map);
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			Connector.close();
			ps = null;
			conn = null;
		}
		return null;
	}

	public Map<String, Object> selectMember(int mNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Object> choiceMember = new HashMap<String, Object>();

		try {
			conn = Connector.open();
			String sql = "select m_num,m_name,m_id,m_pw,m_credate from member where m_num= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				choiceMember.put("m_num", rs.getInt("m_num"));
				choiceMember.put("m_name", rs.getString("m_name"));
				choiceMember.put("m_pw", rs.getString("m_pw"));
				choiceMember.put("m_id", rs.getString("m_id"));
				choiceMember.put("m_credate", rs.getString("m_credate"));
				return choiceMember;
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

	public static void main(String[] args) {
		MemberDAO member = new MemberDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("m_name", "111");
		map.put("m_id", "111");
		map.put("m_pw", "111");
		List<Map<String, Object>> list = new ArrayList<>();

//		member.insertMember(map);
//		int i = member.updateMember(map);
		System.out.println(member.deleteMember(1));
	}

}
