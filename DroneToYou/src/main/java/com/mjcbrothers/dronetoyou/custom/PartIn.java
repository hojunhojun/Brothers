package com.mjcbrothers.dronetoyou.custom;

import java.math.BigDecimal;

public class PartIn {
	private BigDecimal dp_no;
	private String dp_writer;
	private String dp_purpose;
	private String dp_model;
	private String dp_color;
	private String dp_drawing;
	private String dp_quantity;
	private String dp_material;
	private String dp_details;
	
	public PartIn() {
		// TODO Auto-generated constructor stub
	}

	public PartIn(BigDecimal dp_no, String dp_writer, String dp_purpose, String dp_model, String dp_color,
			String dp_drawing, String dp_quantity, String dp_material, String dp_details) {
		super();
		this.dp_no = dp_no;
		this.dp_writer = dp_writer;
		this.dp_purpose = dp_purpose;
		this.dp_model = dp_model;
		this.dp_color = dp_color;
		this.dp_drawing = dp_drawing;
		this.dp_quantity = dp_quantity;
		this.dp_material = dp_material;
		this.dp_details = dp_details;
	}

	public BigDecimal getDp_no() {
		return dp_no;
	}

	public void setDp_no(BigDecimal dp_no) {
		this.dp_no = dp_no;
	}

	public String getDp_writer() {
		return dp_writer;
	}

	public void setDp_writer(String dp_writer) {
		this.dp_writer = dp_writer;
	}

	public String getDp_purpose() {
		return dp_purpose;
	}

	public void setDp_purpose(String dp_purpose) {
		this.dp_purpose = dp_purpose;
	}

	public String getDp_model() {
		return dp_model;
	}

	public void setDp_model(String dp_model) {
		this.dp_model = dp_model;
	}

	public String getDp_color() {
		return dp_color;
	}

	public void setDp_color(String dp_color) {
		this.dp_color = dp_color;
	}

	public String getDp_drawing() {
		return dp_drawing;
	}

	public void setDp_drawing(String dp_drawing) {
		this.dp_drawing = dp_drawing;
	}

	public String getDp_quantity() {
		return dp_quantity;
	}

	public void setDp_quantity(String dp_quantity) {
		this.dp_quantity = dp_quantity;
	}

	public String getDp_material() {
		return dp_material;
	}

	public void setDp_material(String dp_material) {
		this.dp_material = dp_material;
	}

	public String getDp_details() {
		return dp_details;
	}

	public void setDp_details(String dp_details) {
		this.dp_details = dp_details;
	}

	
}
