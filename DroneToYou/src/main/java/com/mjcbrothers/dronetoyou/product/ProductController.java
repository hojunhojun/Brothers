package com.mjcbrothers.dronetoyou.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjcbrothers.dronetoyou.member.MemberDAO;

@Controller
public class ProductController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/product.sale.go", method = RequestMethod.GET)
	public String productSaleGo(HttpServletRequest request) {
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "product/products.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/product.rental.go", method = RequestMethod.GET)
	public String productRentalGo(HttpServletRequest request) {
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "product/rentals.jsp");
		return "index";
	}

	@RequestMapping(value = "/product.sale.detail.go", method = RequestMethod.GET)
	public String productDetailGo(HttpServletRequest request) {
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "product/productDetail.jsp");
		return "index";
	}
	
}
