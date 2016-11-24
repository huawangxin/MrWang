
//定义基本函数    set   get  函数 信息函数
package com.sp.model;

public class GoodsBean {
	
			
	private long goodsId;
	private String goodsName;
	private String goodsIntro;
	private	float goodsPrice ;
	private	int	goodsNum ;
	private	String publisher ;
	private	String photo;
	private	String type ;
	
	public String toString() {
		return goodsId+" "+goodsName+" "+goodsIntro+" "+goodsPrice+" "+goodsNum
		+" "+publisher+" "+photo+" "+type;
	}
	public GoodsBean() {
		super();
	}
	public GoodsBean(long goodsId, String goodsName, String goodsIntro,
			float goodsPrice, int goodsNum, String publisher, String photo,
			String type) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsIntro = goodsIntro;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
		this.publisher = publisher;
		this.photo = photo;
		this.type = type;
	}

	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {//intro 介绍
		this.goodsIntro = goodsIntro;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
