/**
 * 这是一个model，表示User表，实际是javaBean
 */
package com.sp.model;

public class UserBean {
	private long userid ;
	private String username ;
	private String truename ;
	private String	passwd ;
	private String email ;
	private String phone ;
	private String address ;
	private String postcode ;
	private int grade;
	
	public String toString() {
		return userid+" "+username+" "+truename+" "+passwd+" "+email+" "+phone+" "+address
		+" "+postcode;
	}
	public UserBean() {
		super();
	}
	public UserBean(long userid, String username, String truename,
			String passwd, String email, String phone, String address,
			String postcode, int grade) {
		super();
		this.userid = userid;
		this.username = username;
		this.truename = truename;
		this.passwd = passwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postcode = postcode;
		this.grade = grade;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
