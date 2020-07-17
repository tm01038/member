package com.member.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.MemberService;
import com.member.lib.service.impl.MemberServiceImpl;
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	
	
	private void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(str);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri =request.getRequestURI();
		String str = "";
		
		if("/member/list".equals(uri)) {
			List<Map<String, Object>> memberList =memberService.selectMemberList(null);
			str = memberList.toString();
		}else if("/member/view".equals(uri)) {
			String m_num = request.getParameter("m_num");
			if(m_num==null ||"".equals(m_num.trim())) {
				throw new ServletException("오라오라오라오라오라오라");
			}
			int mNum = Integer.parseInt(m_num);
			Map<String, Object> member = memberService.selectMember(mNum);
			if(member != null) {
			str=member.toString();
			}else {
				str="없는번호";
			}
		}else {
			str="잘못들어갔어 새꺄";
		}
		doProcess(response,str);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if("/member/insert".equals(uri)) {
			String mName =request.getParameter("m_name");
			String mId =request.getParameter("m_id");
			String mPw =request.getParameter("m_pw");
			Map<String,Object> member = new HashMap<>();
			member.put("m_name", mName);
			member.put("m_id", mId);
			member.put("m_pw", mPw);
			
			doProcess(response, memberService.insertMember(member).toString());
		}
	}

}
