package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
			String sql = "insert into member(M_num,M_name,M_id,M_pw,M_credate)\r\n"
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
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = Connector.open();
			String sql = " update member set ";
			Iterator<String> it = member.keySet().iterator();
			Map<String, Object> setColm = new LinkedHashMap<>();
			String whereNum = null;
			while (it.hasNext()) {
				String key = it.next();
				String value = member.get(key).toString();
				if (key.equals("m_num")) {
					whereNum = " where " + key + "= ? ";
					continue;
				}
				setColm.put(key, value);
			}
			int idxColm = 1;
			for (String keys : setColm.keySet()) {
				if (idxColm != setColm.size())
					sql += keys + "=? ,";
				sql += keys+ "=? ";
				idxColm++;
			}
			sql += whereNum;
			ps=conn.prepareStatement(sql);
			idxColm = 1;
			for (String keys : setColm.keySet()) {
				ps.setString(idxColm, member.get(keys).toString());
				idxColm++;
			}
			
			result = ps.executeUpdate();
			conn.rollback();
			// " update member set m_name='정원돌' where m_num=3 ";
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

	public int deleteMember(int mNum) {
		return 0;
	}

	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		List<Map<String, Object>> memberList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = Connector.open();
			String sql = "SELECT m_num,m_name,m_id,m_credate FROM MEMBER ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
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
		return null;
	}

	public static void main(String[] args) {
		MemberDAO member = new MemberDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("m_num",3);
		map.put("m_name","111");
		map.put("m_id","111");
		map.put("m_pw","111");
		map.put("m_credate","111");
		List<Map<String, Object>> list = new ArrayList<>();

		int i = member.updateMember(map);
		System.out.println(i);
	}

}
