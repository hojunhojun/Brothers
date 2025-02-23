package com.mjcbrothers.dronetoyou.cs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjcbrothers.dronetoyou.c2c.C2CDAO;
import com.mjcbrothers.dronetoyou.c2c.C2CRequest;
import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class CustomerServiceController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private C2CDAO cDAO;
	
	
	@RequestMapping(value = "/inquiry.go", method = RequestMethod.GET)
	public String inquiryGo(HttpServletRequest request) {
		mDAO.isLogined(request);
		cDAO.searchClear(request);
		request.setAttribute("contentPage", "inquiryForm.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/cservice.request.submit", method = RequestMethod.POST)
	public String cserviceRequestSubmit(C2CRequest ccr, HttpServletRequest request) {
		if(mDAO.isLogined(request)) {
			cDAO.insertCserviceRequest(request);
		}
		cDAO.getSubmitRequest(ccr, request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
