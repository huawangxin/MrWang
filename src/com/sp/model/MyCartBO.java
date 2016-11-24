package com.sp.model;//model，处理购物
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.*;

//hashmap集合的使用
public class MyCartBO {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	//定义一个hashmap集合，用于存放id和数量
	HashMap<String,String> hm=new HashMap<String,String>();//泛型
	private float allPrice=0.0f;
	/**
	 * 返回购物车的总价
	 */
	public float getAllPrice(){
		return this.allPrice;
	}
	
	//根据id返回货物的数量
	public String getGoodsNumById(String goodsId){
		return (String)hm.get(goodsId);
	}
	//1.添加货物
	public void addGoods(String goodsId,String goodsNum){
		hm.put(goodsId, goodsNum);
	}
	//2.删除货物
	public void delGoods(String goodsId){
		hm.remove(goodsId);
	}
	//3.清空货物
	public void clear(){
		hm.clear();
	}
	//4.修改货物数量
	public void upGoods(String goodsId,String newNum){
		hm.put(goodsId, newNum);
	}
	//5.显示购物车
	public ArrayList showMyCart() throws Exception{
		ArrayList <GoodsBean> al=new ArrayList<GoodsBean>();			//泛型功能
		try{
			//组织sql
			String sql="select * from goods_wangxin where goodsId in";
			// 使用迭代器完成从hm中取出货物id的要求
			Iterator it=hm.keySet().iterator();
			String sub="(";
			while(it.hasNext()){
				//取出GoodsId
				String goodsId=(String)it.next();
				//判断是不是最后id
				if(it.hasNext()){
				sub+=goodsId+",";
				}else{
					sub+=goodsId+")";
				}
			}
			sql+=sub;
			ct=DBUTil.getConnection();
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			//总价清空
			this.allPrice=0.0f;
			while(rs.next()){
				GoodsBean gb=new GoodsBean();
				int goodsId=rs.getInt(1);
				gb.setGoodsId(goodsId);
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				float unit=rs.getFloat(4);
				gb.setGoodsPrice(unit);
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				this.allPrice=this.allPrice+unit*Integer.parseInt(this.getGoodsNumById(goodsId+""));
				//加入arraylist
				al.add(gb);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUTil.close(ct);
		}
		return al;
	}
}
