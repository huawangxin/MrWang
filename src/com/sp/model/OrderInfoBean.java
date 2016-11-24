package com.sp.model;

import java.util.Date;

//这个javabean包含了用户表和订单表
public class OrderInfoBean {

	private int userid ;
	private String username ;
	private String truename ;
	private String	passwd ;
	private String email ;
	private String phone ;
	private String address ;
	private String postcode ;
	private int grade;
	private long ordersId ;
	private long userId;
	private java.util.Date orderDate;//日期的定义
	private String payMode;
	private byte isPayed;
	private float totalPrice;
	
	@Override
	public String toString() {
		return userid+" "+username+" "+truename+" "+passwd+" "+email+" "+phone
		+" "+address+" "+postcode+" "+grade+" "+ordersId+" "+userId+" "+orderDate+" "+
		payMode+" "+isPayed+" "+totalPrice;
	}
	public OrderInfoBean() {
		super();
	}
	public OrderInfoBean(int userid, String username, String truename,
			String passwd, String email, String phone, String address,
			String postcode, int grade, long ordersId, long userId2,
			Date orderDate, String payMode, byte isPayed, float totalPrice) {
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
		this.ordersId = ordersId;
		userId = userId2;
		this.orderDate = orderDate;
		this.payMode = payMode;
		this.isPayed = isPayed;
		this.totalPrice = totalPrice;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
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
	public long getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(long ordersId) {
		this.ordersId = ordersId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public byte getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(byte isPayed) {
		this.isPayed = isPayed;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
