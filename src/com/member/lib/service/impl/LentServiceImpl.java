package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {
	
	private LentDAO lentDAO = new LentDAOImpl();
	
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.insertLent(lent);
		rMap.put("mag",(result != 1)?"빌린도서 입력실패":"빌린도서 입력성공");
		return rMap;
	}

	public Map<String, Object> updateLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.updateLent(lent);
		rMap.put("mag",(result != 1)?"빌린도서 변경실패":"빌린도서 변경성공");
		return rMap;
	}

	public Map<String, Object> deleteLent(int lNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.deleteLent(lNum);
		rMap.put("mag",(result != 1)?"반납 실패":"반납 성공");
		return rMap;
	}

	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {
		return lentDAO.selectLentList(lent);
	}

	public Map<String, Object> selectLent(int lNum) {
		return lentDAO.selectLent(lNum);
	}
	
	public static void main(String[] args) {
		LentService lentService = new LentServiceImpl();
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("m_num", 1);
		System.out.println(lentService.selectLent(1));
	}
}
