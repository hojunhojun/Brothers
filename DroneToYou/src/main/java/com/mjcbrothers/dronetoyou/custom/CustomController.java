package com.mjcbrothers.dronetoyou.custom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjcbrothers.dronetoyou.LeeTokenGenerator;
import com.mjcbrothers.dronetoyou.c2c.C2CDAO;
import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class CustomController {
	
	@Autowired
	private LeeTokenGenerator ltg;
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private C2CDAO cDAO;
	
	@Autowired
	private CustomDAO csDAO;
	
	@RequestMapping(value = "/custom.survey.go", method = RequestMethod.GET)
	public String customSurveyGo(HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			cDAO.searchClear(request);
			request.setAttribute("contentPage", "custom/surveyForm.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/custom.survey.submit", method = RequestMethod.POST)
	public String customSurveySubmit(Survey s, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			csDAO.surveySubmit(s, request);
		}
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/custom.partin.go", method = RequestMethod.GET)
	public String customPartInGo(HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			cDAO.searchClear(request);
			request.setAttribute("contentPage", "custom/partInquiryForm.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/custom.partin.submit", method = RequestMethod.POST)
	public String customPartinSubmit(PartIn pi, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			csDAO.surveyPartIn(pi, request);
		}
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
