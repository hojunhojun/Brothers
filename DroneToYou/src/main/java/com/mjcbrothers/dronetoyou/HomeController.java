package com.mjcbrothers.dronetoyou;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest request) {
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
}
