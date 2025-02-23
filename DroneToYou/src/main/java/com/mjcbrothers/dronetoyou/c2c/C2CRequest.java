package com.mjcbrothers.dronetoyou.c2c;

import java.math.BigDecimal;

public class C2CRequest {
	private BigDecimal dcr_no;
	private String dcr_txt;
	private String dcr_writer;
	private String dcr_responser;
	
	public C2CRequest() {
		// TODO Auto-generated constructor stub
	}

	public C2CRequest(BigDecimal dcr_no, String dcr_txt, String dcr_writer, String dcr_responser) {
		super();
		this.dcr_no = dcr_no;
		this.dcr_txt = dcr_txt;
		this.dcr_writer = dcr_writer;
		this.dcr_responser = dcr_responser;
	}

	public BigDecimal getDcr_no() {
		return dcr_no;
	}

	public void setDcr_no(BigDecimal dcr_no) {
		this.dcr_no = dcr_no;
	}

	public String getDcr_txt() {
		return dcr_txt;
	}

	public void setDcr_txt(String dcr_txt) {
		this.dcr_txt = dcr_txt;
	}

	public String getDcr_writer() {
		return dcr_writer;
	}

	public void setDcr_writer(String dcr_writer) {
		this.dcr_writer = dcr_writer;
	}

	public String getDcr_responser() {
		return dcr_responser;
	}

	public void setDcr_responser(String dcr_responser) {
		this.dcr_responser = dcr_responser;
	}
	
	
}
