

package com.sp.model;
import java.sql.*;
import java.util.ArrayList;
public class GoodsBeanBO {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	
	/**
	 * �����ж���ҳ
	 * @throws Exception 
	 */
	public int getPageCount(int pageSize) throws Exception{
		int pageCount=0;
		int rowCount=0;
		try	{
			ct=DBUTil.getConnection();//�������ݿ�
			ps=ct.prepareStatement("select count(*) from goods");//׼������
			rs=ps.executeQuery();
			if(rs.next()){
				 rowCount=rs.getInt(1);
			}
			//����pagecount 
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUTil.close(ct);
		}
		return pageCount;
	}
	
	/**
	 * ��ҳ	 
	 * @throws Exception 
	 */
	public ArrayList getGoodsByPage(int pageSize,int pageNow) throws Exception{
		
		ArrayList al=new ArrayList();
		try{
			ct=DBUTil.getConnection();
			ps=ct.prepareStatement("select  * from goods limit " +pageSize*(pageNow-1) +","+ pageSize );
			//limit s��n   ��s��n֮�����
			rs=ps.executeQuery();
		while(rs.next()){
			GoodsBean gb=new GoodsBean();
			gb.setGoodsId(rs.getInt(1));//�õ��ڼ��е�ֵ
			gb.setGoodsName(rs.getString(2));
			gb.setGoodsIntro(rs.getString(3));
			gb.setGoodsPrice(rs.getFloat(4));
			gb.setGoodsNum(rs.getInt(5));
			gb.setPublisher(rs.getString(6));
			gb.setPhoto(rs.getString(7));
			gb.setType(rs.getString(8));
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
	//����һ������id���õ����������Ϣ����
	public GoodsBean getGoodsBean(String id) throws Exception{		
		
		GoodsBean gb=new GoodsBean();
		try{
			ct=DBUTil.getConnection();
			ps=ct.prepareStatement("select * from goods where goodsId=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUTil.close(ct);
		}
		return gb;
	}
	
}
