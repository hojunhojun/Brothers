package com.mjcbrothers.dronetoyou.c2c;

import java.math.BigDecimal;
import java.util.Date;

public class C2C {
	private BigDecimal dc_no;
	private String dc_txt;
	private String dc_writer;
	private String dc_cate;
	private String dc_title;
	private String dc_interval;
	private Date dc_date;
	private String dc_photo1;
	
	public C2C() {

	}

	
	public C2C(BigDecimal dc_no, String dc_txt, String dc_writer, String dc_cate, String dc_title, String dc_interval,
			Date dc_date, String dc_photo1) {
		super();
		this.dc_no = dc_no;
		this.dc_txt = dc_txt;
		this.dc_writer = dc_writer;
		this.dc_cate = dc_cate;
		this.dc_title = dc_title;
		this.dc_interval = dc_interval;
		this.dc_date = dc_date;
		this.dc_photo1 = dc_photo1;
	}

	public BigDecimal getDc_no() {
		return dc_no;
	}

	public void setDc_no(BigDecimal dc_no) {
		this.dc_no = dc_no;
	}

	public String getDc_txt() {
		return dc_txt;
	}

	public void setDc_txt(String dc_txt) {
		this.dc_txt = dc_txt;
	}

	public String getDc_writer() {
		return dc_writer;
	}

	public void setDc_writer(String dc_writer) {
		this.dc_writer = dc_writer;
	}

	public String getDc_cate() {
		return dc_cate;
	}

	public void setDc_cate(String dc_cate) {
		this.dc_cate = dc_cate;
	}

	public String getDc_title() {
		return dc_title;
	}

	public void setDc_title(String dc_title) {
		this.dc_title = dc_title;
	}

	public String getDc_interval() {
		return dc_interval;
	}

	public void setDc_interval(String dc_interval) {
		this.dc_interval = dc_interval;
	}

	public Date getDc_date() {
		return dc_date;
	}

	public void setDc_date(Date dc_date) {
		this.dc_date = dc_date;
	}

	public String getDc_photo1() {
		return dc_photo1;
	}

	public void setDc_photo1(String dc_photo1) {
		this.dc_photo1 = dc_photo1;
	}

	
	
	
}
