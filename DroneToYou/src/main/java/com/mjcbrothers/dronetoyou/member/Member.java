package com.mjcbrothers.dronetoyou.member;

import java.util.Date;

public class Member {
	private String dm_id;
	private String dm_pw;
	private String dm_name;
	private String dm_phone;
	private Date dm_birthday;
	private String dm_email;
	private String dm_photo;
	
	public Member() {

	}

	public String getDm_id() {
		return dm_id;
	}

	public void setDm_id(String dm_id) {
		this.dm_id = dm_id;
	}

	public String getDm_pw() {
		return dm_pw;
	}

	public void setDm_pw(String dm_pw) {
		this.dm_pw = dm_pw;
	}

	public String getDm_name() {
		return dm_name;
	}

	public void setDm_name(String dm_name) {
		this.dm_name = dm_name;
	}

	public String getDm_phone() {
		return dm_phone;
	}

	public void setDm_phone(String dm_phone) {
		this.dm_phone = dm_phone;
	}

	public Date getDm_birthday() {
		return dm_birthday;
	}

	public void setDm_birthday(Date dm_birthday) {
		this.dm_birthday = dm_birthday;
	}

	public String getDm_email() {
		return dm_email;
	}

	public void setDm_email(String dm_email) {
		this.dm_email = dm_email;
	}

	public String getDm_photo() {
		return dm_photo;
	}

	public void setDm_photo(String dm_photo) {
		this.dm_photo = dm_photo;
	}

	public Member(String dm_id, String dm_pw, String dm_name, String dm_phone, Date dm_birthday, String dm_email,
			String dm_photo) {
		super();
		this.dm_id = dm_id;
		this.dm_pw = dm_pw;
		this.dm_name = dm_name;
		this.dm_phone = dm_phone;
		this.dm_birthday = dm_birthday;
		this.dm_email = dm_email;
		this.dm_photo = dm_photo;
	}
	
}
