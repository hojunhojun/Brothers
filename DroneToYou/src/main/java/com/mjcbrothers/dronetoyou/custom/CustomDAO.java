package com.mjcbrothers.dronetoyou.custom;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjcbrothers.dronetoyou.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class CustomDAO {

	@Autowired
	private SqlSession ss;
	
	public void surveySubmit(Survey s, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String token = mr.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				return;				
			}
			String photo = URLEncoder.encode(mr.getFilesystemName("ds_blueprint"), "utf-8").replace("+", " ");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			s.setDs_writer(m.getDm_id());
			s.setDs_wingsize(mr.getParameter("ds_wingsize"));
			s.setDs_wingcount(mr.getParameter("ds_wingcount"));
			s.setDs_purpose(mr.getParameter("ds_purpose"));
			s.setDs_required(mr.getParameter("ds_required"));
			s.setDs_battery(mr.getParameter("ds_required"));
			s.setDs_bodysize(mr.getParameter("ds_bodysize"));			
			s.setDs_blueprint(photo);
			s.setDs_painting(mr.getParameter("ds_painting"));
			
			if (ss.getMapper(CustomMapper.class).regSurvey(s) == 1) {
				request.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(path + "/" + mr.getFilesystemName("dm_photo1")).delete();
		}
	}

	public void surveyPartIn(PartIn pi, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String token = mr.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				return;				
			}
			String photo = URLEncoder.encode(mr.getFilesystemName("dp_drawing"), "utf-8").replace("+", " ");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			pi.setDp_writer(m.getDm_id());
			pi.setDp_purpose(mr.getParameter("dp_purpose"));
			pi.setDp_model(mr.getParameter("dp_model"));
			pi.setDp_color(mr.getParameter("dp_color"));
			pi.setDp_drawing(photo);
			pi.setDp_quantity(mr.getParameter("dp_quantity"));
			pi.setDp_material(mr.getParameter("dp_material"));
			pi.setDp_details(mr.getParameter("dp_details"));
			
			if (ss.getMapper(CustomMapper.class).regPartIn(pi) == 1) {
				request.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(path + "/" + mr.getFilesystemName("dm_photo1")).delete();
		}
	}
}
