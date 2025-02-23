package com.mjcbrothers.dronetoyou.member;

import java.io.File;
import java.net.URLDecoder;
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
	
	public boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("loginPage", "member/logined.jsp");
			return true;
		}
		request.setAttribute("loginPage", "member/login.jsp");
		return false;
	}

	public void login(Member m, HttpServletRequest request) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			if (dbMember != null) {
				if (m.getDm_pw().equals(dbMember.getDm_pw())) {
					request.getSession().setAttribute("loginMember", dbMember);
					request.getSession().setMaxInactiveInterval(10000);
				} else {
					request.setAttribute("result", "로그인 실패(pw)");
				}
			} else {
				request.setAttribute("result", "로그인 실패(미가입 ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인실패(DB문제");
		}
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
			String phone3 = mr.getParameter("phone3");
			String phone4 = phone1 + "-" + phone2 + "-" + phone3;
			String y = mr.getParameter("y");
			int m2 = Integer.parseInt(mr.getParameter("m2"));
			int d = Integer.parseInt(mr.getParameter("d"));
			String bd = String.format("%s%02d%02d", y, m2, d);
			Date bd2 = sdf.parse(bd);
			String email = mr.getParameter("dm_email");
			String p = URLEncoder.encode(mr.getFilesystemName("dm_photo"), "utf-8").replace("+", " ");
			m.setDm_id(id);
			m.setDm_pw(pw);
			m.setDm_name(name);
			m.setDm_phone(phone4);
			m.setDm_birthday(bd2);
			m.setDm_email(email);
			m.setDm_photo(p);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				request.setAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입실패");
			new File(path + "/" + mr.getFilesystemName("dm_photo")).delete();
		}
	}

	public void logout(HttpServletRequest request) {
		request.getSession().setAttribute("loginMember", null);
	}
	
	public void update(Member m, HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		
		try {
			mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패(파일용량)");
		}
		
		String oldPhoto = null;
		String newPhoto = null;
		try {
			Member oldMember = (Member) request.getSession().getAttribute("loginMember");
			String id = oldMember.getDm_id();
			oldPhoto = oldMember.getDm_photo();
			String pw = mr.getParameter("dm_pw");
			newPhoto = mr.getFilesystemName("dm_photo");
			if (newPhoto == null) { // 프사 수정하는 정상적인 친구
				newPhoto = oldPhoto;
			} else { // 프사 수정 안하는
				newPhoto = URLEncoder.encode(newPhoto, "utf-8").replace("+", " ");
			}
			String name=mr.getParameter("dm_name");
			String phone1 = mr.getParameter("phone1");
			String phone2 = mr.getParameter("phone2");
			String phone3 = mr.getParameter("phone3");
			String phone4 = phone1 + "-" + phone2 + "-" + phone3;
			String email = mr.getParameter("dm_email");
			m.setDm_id(id);		m.setDm_pw(pw);		m.setDm_name(name);
			m.setDm_phone(phone4);					m.setDm_email(email);
			m.setDm_photo(newPhoto);
			m.setDm_birthday(oldMember.getDm_birthday());
			
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				request.setAttribute("result", "수정성공");
				
				request.getSession().setAttribute("loginMember", m);
				
				if (!oldPhoto.equals(newPhoto)) {
					oldPhoto = URLDecoder.decode(oldPhoto, "utf-8");
					new File(path + "/" + oldPhoto).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
			try {
				if (!oldPhoto.equals(newPhoto)) {
					newPhoto = URLDecoder.decode(newPhoto, "utf-8");
					new File(path + "/" + newPhoto).delete();					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void bye(HttpServletRequest request) {
		try {
			Member m = (Member) request.getSession().getAttribute("loginMember");

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				request.setAttribute("result", "탈퇴성공");
				
				String path = request.getSession().getServletContext().getRealPath("img");
				String file = m.getDm_photo();
				new File(path + "/" + file).delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "탈퇴실패");
		}
	}
	
	public void dividePhone(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String phone = m.getDm_phone();
		String[] phones = phone.split("-");
		request.setAttribute("phone1", phones[0]);
		request.setAttribute("phone2", phones[1]);
		request.setAttribute("phone3", phones[2]);
	}
}
