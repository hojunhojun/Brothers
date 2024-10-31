package com.mjcbrothers.dronetoyou.member;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void login(Member m, HttpServletRequest request) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			if (dbMember != null) {
				if (m.getDm_pw().equals(dbMember.getDm_pw())) {
					request.getSession().setAttribute("loginMember", dbMember);
					request.getSession().setMaxInactiveInterval(10000);
					System.out.println("로그인 성공");
				} else {
					request.setAttribute("result", "로그인 실패(pw)");
					System.out.println("로그인 실패");
				}
			} else {
				request.setAttribute("result", "로그인 실패(미가입 ID)");
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인실패(DB문제");
			System.out.println("로그인 실패");
		}
	}
	
	public boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("loginPage", "member/logined.jsp");
			return true;
		}
		request.setAttribute("loginPage", "member/login.jsp");
		return false;
	}
}
