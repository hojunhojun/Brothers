package com.mjcbrothers.dronetoyou.c2c;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mjcbrothers.dronetoyou.DateManager;
import com.mjcbrothers.dronetoyou.LeeTokenGenerator;
import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class C2CController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private C2CDAO cDAO;
	
	@Autowired
	private LeeTokenGenerator ltg;
	
	@RequestMapping(value = "/c2c.go", method = RequestMethod.GET)
	public String c2cGo(HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			DateManager.getCurYear(request);
			cDAO.searchClear(request);
			cDAO.get(1, request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/c2c.reg.do", method = RequestMethod.POST)
	public String c2cRegDo(C2C c, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {			
			ltg.generate(request);
			cDAO.reg(c, request);
			cDAO.searchClear(request);
			cDAO.get(1, request);
			DateManager.getCurYear(request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/c2c.search", method = RequestMethod.GET)
	public String snsSearch(HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			cDAO.search(request);
			ltg.generate(request);
			cDAO.get(1, request);
			DateManager.getCurYear(request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/c2c.page.change")
	public String c2cPageChange(int page, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			cDAO.get(page , request);
			DateManager.getCurYear(request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");			
		}
		return "index";
	}
	
	@RequestMapping(value = "/c2c.delete.do", method = RequestMethod.GET)
	public String snsPostDelete(C2C c, @RequestParam(value="page") int page, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			cDAO.delete(c, request);
			ltg.generate(request);
			cDAO.searchClear(request);
			cDAO.get(page, request);
			DateManager.getCurYear(request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/c2c.update.do", method = RequestMethod.POST)
	public String c2cUpdateDo(C2C c, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {			
			ltg.generate(request);
			cDAO.update(c, request);
			cDAO.searchClear(request);
			cDAO.get(1, request);
			DateManager.getCurYear(request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/c2c.submit.request.do", method = RequestMethod.GET)
	public String c2cSubmitRequest(C2CRequest ccr, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {			
			ltg.generate(request);
			cDAO.doSubmitRequest(ccr, request);
			cDAO.searchClear(request);
			cDAO.get(1, request);
			request.setAttribute("contentPage", "c2c/c2c.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

}
