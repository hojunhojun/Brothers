package com.mjcbrothers.dronetoyou;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjcbrothers.dronetoyou.c2c.C2CDAO;
import com.mjcbrothers.dronetoyou.c2c.C2CRequest;
import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class HomeController {
	
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private C2CDAO cDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(C2CRequest ccr, HttpServletRequest request) {
		if (firstReq) {
			cDAO.setAllC2CCount();
			firstReq = false;
		}
		mDAO.isLogined(request);
		cDAO.searchClear(request);
		cDAO.getSubmitRequest(ccr, request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String goIndex(C2CRequest ccr, HttpServletRequest request) {
		return home(ccr, request);
	}
	
}
