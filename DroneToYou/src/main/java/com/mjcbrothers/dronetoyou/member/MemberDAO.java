package com.mjcbrothers.dronetoyou.member;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	private SimpleDateFormat sdf;

	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}
	
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
					System.out.println("로그인 실패1");
				}
			} else {
				request.setAttribute("result", "로그인 실패(미가입 ID)");
				System.out.println("로그인 실패2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인실패(DB문제");
			System.out.println("로그인 실패3");
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

	public void join(Member m, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			request.setAttribute("result", "가입실패(DB문제)");
			e.printStackTrace();
		}
		try {
			String id = mr.getParameter("dm_id");
			String pw = mr.getParameter("dm_pw");
			
			String name = mr.getParameter("dm_name");
			
			String phone1 = mr.getParameter("phone1");
			String phone2 = mr.getParameter("phone2");
			String phone = "010" + phone1 + phone2;
			
			String j1 = mr.getParameter("dm_jumin1");
			String j2 = mr.getParameter("dm_jumin2");
			if (j2.equals("1") || j2.equals("2")) {
				j1 = 19 + j1;
			} else if (j2.equals("3") || j2.equals("4")) {
				j1 = 20 + j1;
			}
			Date bd = sdf.parse(j1);
			String email = mr.getParameter("dm_email");
			String p = URLEncoder.encode(mr.getFilesystemName("dm_photo"), "utf-8").replace("+", " ");
			m.setDm_id(id);
			m.setDm_pw(pw);
			m.setDm_name(name);
			m.setDm_phone(phone);
			m.setDm_birthday(bd);
			m.setDm_email(email);
			m.setDm_photo(p);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				request.setAttribute("result", "가입성공");
				System.out.println("가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입실패");
			System.out.println("가입실패");
			new File(path + "/" + mr.getFilesystemName("dm_photo")).delete();
		}
	}
}
