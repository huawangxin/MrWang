package com.sp.model;//model��������
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.*;

//hashmap���ϵ�ʹ��
public class MyCartBO {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	//����һ��hashmap���ϣ����ڴ��id������
	HashMap<String,String> hm=new HashMap<String,String>();//����
	private float allPrice=0.0f;
	/**
	 * ���ع��ﳵ���ܼ�
	 */
	public float getAllPrice(){
		return this.allPrice;
	}
	
	//����id���ػ��������
	public String getGoodsNumById(String goodsId){
		return (String)hm.get(goodsId);
	}
	//1.��ӻ���
	public void addGoods(String goodsId,String goodsNum){
		hm.put(goodsId, goodsNum);
	}
	//2.ɾ������
	public void delGoods(String goodsId){
		hm.remove(goodsId);
	}
	//3.��ջ���
	public void clear(){
		hm.clear();
	}
	//4.�޸Ļ�������
	public void upGoods(String goodsId,String newNum){
		hm.put(goodsId, newNum);
	}
	//5.��ʾ���ﳵ
	public ArrayList showMyCart() throws Exception{
		ArrayList <GoodsBean> al=new ArrayList<GoodsBean>();			//���͹���
		try{
			//��֯sql
			String sql="select * from goods_wangxin where goodsId in";
			// ʹ�õ�������ɴ�hm��ȡ������id��Ҫ��
			Iterator it=hm.keySet().iterator();
			String sub="(";
			while(it.hasNext()){
				//ȡ��GoodsId
				String goodsId=(String)it.next();
				//�ж��ǲ������id
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
			//�ܼ����
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
				//����arraylist
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
