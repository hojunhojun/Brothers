package com.mjcbrothers.dronetoyou.custom;

import java.math.BigDecimal;

public class Survey {
	private BigDecimal ds_no;
	private String ds_writer;
	private String ds_wingsize;
	private String ds_wingcount;
	private String ds_purpose;
	private String ds_required;
	private String ds_battery;
	private String ds_bodysize;
	private String ds_blueprint;
	private String ds_painting;
	
	public Survey() {
		// TODO Auto-generated constructor stub
	}

	public Survey(BigDecimal ds_no, String ds_writer, String ds_wingsize, String ds_wingcount, String ds_purpose,
			String ds_required, String ds_battery, String ds_bodysize, String ds_blueprint, String ds_painting) {
		super();
		this.ds_no = ds_no;
		this.ds_writer = ds_writer;
		this.ds_wingsize = ds_wingsize;
		this.ds_wingcount = ds_wingcount;
		this.ds_purpose = ds_purpose;
		this.ds_required = ds_required;
		this.ds_battery = ds_battery;
		this.ds_bodysize = ds_bodysize;
		this.ds_blueprint = ds_blueprint;
		this.ds_painting = ds_painting;
	}

	public BigDecimal getDs_no() {
		return ds_no;
	}

	public void setDs_no(BigDecimal ds_no) {
		this.ds_no = ds_no;
	}

	public String getDs_writer() {
		return ds_writer;
	}

	public void setDs_writer(String ds_writer) {
		this.ds_writer = ds_writer;
	}

	public String getDs_wingsize() {
		return ds_wingsize;
	}

	public void setDs_wingsize(String ds_wingsize) {
		this.ds_wingsize = ds_wingsize;
	}

	public String getDs_wingcount() {
		return ds_wingcount;
	}

	public void setDs_wingcount(String ds_wingcount) {
		this.ds_wingcount = ds_wingcount;
	}

	public String getDs_purpose() {
		return ds_purpose;
	}

	public void setDs_purpose(String ds_purpose) {
		this.ds_purpose = ds_purpose;
	}

	public String getDs_required() {
		return ds_required;
	}

	public void setDs_required(String ds_required) {
		this.ds_required = ds_required;
	}

	public String getDs_battery() {
		return ds_battery;
	}

	public void setDs_battery(String ds_battery) {
		this.ds_battery = ds_battery;
	}

	public String getDs_bodysize() {
		return ds_bodysize;
	}

	public void setDs_bodysize(String ds_bodysize) {
		this.ds_bodysize = ds_bodysize;
	}

	public String getDs_blueprint() {
		return ds_blueprint;
	}

	public void setDs_blueprint(String ds_blueprint) {
		this.ds_blueprint = ds_blueprint;
	}

	public String getDs_painting() {
		return ds_painting;
	}

	public void setDs_painting(String ds_painting) {
		this.ds_painting = ds_painting;
	}
	
	
}
