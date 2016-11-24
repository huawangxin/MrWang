//model,和orders表对应
package com.sp.model;

import java.util.Date;

public class OrderBean {

	private long ordersId ;
	private long userId;
	private java.util.Date orderDate;//日期的定义  ！！！！
	private String payMode;
	private byte isPayed;
	private float totalPrice;
	
	public String toString() {
		return ordersId+" "+userId+" "+orderDate+" "+payMode+" "+totalPrice;
	}
	public OrderBean() {
		super();
	}
	public OrderBean(long ordersId, long userId, Date orderDate,
			String payMode, byte isPayed, float totalPrice) {
		super();
		this.ordersId = ordersId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.payMode = payMode;
		this.isPayed = isPayed;
		this.totalPrice = totalPrice;
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
