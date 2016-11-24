package com.sp.model;

public class OrderDetailBean {

	private long ordersIid;
	private long goodsId;
	private int nums;
	
	public long getOrdersIid() {
		return ordersIid;
	}
	public void setOrdersIid(long ordersIid) {
		this.ordersIid = ordersIid;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
}
