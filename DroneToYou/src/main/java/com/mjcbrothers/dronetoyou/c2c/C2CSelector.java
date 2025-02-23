package com.mjcbrothers.dronetoyou.c2c;

import java.math.BigDecimal;

public class C2CSelector {
	private BigDecimal start;
	private BigDecimal end;
	private String search;
	
	public C2CSelector() {
		// TODO Auto-generated constructor stub
	}

	public C2CSelector(BigDecimal start, BigDecimal end, String search) {
		super();
		this.start = start;
		this.end = end;
		this.search = search;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
