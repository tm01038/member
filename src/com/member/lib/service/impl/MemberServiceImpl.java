package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAOImpl();
	
	public Map<String, Object> insertMember(Map<String, Object> member) {
		int result = memberDAO.insertMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "맴버등록 완료");
		if(result !=1) {
			rMap.put("msg", "맴버등록 오류!");
			}
		rMap.put("cnt",result);
		return rMap;
	}

	public Map<String, Object> updateMember(Map<String, Object> member) {
		int result = memberDAO.updateMember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "맴버업데이트 완료");
		if(result !=1) {
			rMap.put("msg", "맴버업데이트 오류!");
			}
		rMap.put("cnt",result);
		return rMap;
	}
	public Map<String, Object> deleteMember(int mNum) {
		int result = memberDAO.deleteMember(mNum);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "맴버삭제 완료");
		if(result !=1) {
			rMap.put("msg", "맴버삭제 오류!");
			}
		rMap.put("cnt",result);
		return rMap;
	}
	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		return memberDAO.selectMemberList(member);
	}

	public Map<String, Object> selectMember(int mNum) {
		return memberDAO.selectMember(mNum);
	}
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
//		Map<String, Object> rMap = memberService.deleteMember(41);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("m_name","정원영");
		rMap.put("m_id","tm101");
		rMap.put("m_pw","1234");
		rMap.put("m_num",61);

		

//		System.out.println(memberService.insertMember(rMap));
		System.out.println(memberService.selectMember(21));
		
	}
	

}
