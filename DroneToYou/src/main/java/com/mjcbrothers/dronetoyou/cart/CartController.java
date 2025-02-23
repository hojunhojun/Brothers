package com.mjcbrothers.dronetoyou.cart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjcbrothers.dronetoyou.DateManager;
import com.mjcbrothers.dronetoyou.LeeTokenGenerator;
import com.mjcbrothers.dronetoyou.c2c.C2CDAO;
import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class CartController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private C2CDAO cDAO;
	
	@Autowired
	private LeeTokenGenerator ltg;
	
	@RequestMapping(value = "/cart.go", method = RequestMethod.GET)
	public String cartGo(HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			cDAO.searchClear(request);
			DateManager.getCurYear(request);
			request.setAttribute("contentPage", "cart.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
