//����model����orders��orderDetail�Ĵ���
package com.sp.model;

import java.sql.*;
import java.util.ArrayList;

public class OrderBeanBO {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	
	//ע�ͺ���  ������������
	/**
	 * ���ɶ���
	 * @param mbo �û��Ĺ��ﳵ
	 * @param userId �û�id
	 * @return ���ض�����ϸ��Ϣbean
	 * @throws Exception 
	 */
	public OrderInfoBean addOrder(MyCartBO mbo,String userId) throws Exception{
		OrderInfoBean oib=new OrderInfoBean();
		boolean b=true;
		try{
			ct=DBUTil.getConnection();
			ps=ct.prepareStatement("insert into orders (uesrId,isPayed,totalPrice) values(?,?,?)");
			ps.setString(1, userId);
			ps.setByte(2,(byte)0);
			ps.setFloat(3,mbo.getAllPrice());
			int a=ps.executeUpdate();//���³ɹ�  ����ֵ
			if(a==1){
				//����ȡ���ո���ӵ�orders��Ķ���
				//ȡ�����������orders��id ����
				ps=ct.prepareStatement("select max(ordersId) from orders");
				rs=ps.executeQuery();
				int orderId=0;
				if(rs.next()){
					orderId=rs.getInt(1);
				}
				//orders ����ӳɹ�
				//���ordersDetail
				//�ӹ��ﳵȡ������ѡ���Ļ���
				ArrayList al=mbo.showMyCart();
				//ѭ������ӵ�orderDetail����Ӱ��Ч��
				//ʹ�������������ݿ�ķ��������Ч��
		       Statement sm=ct.createStatement();
				for(int i=0;i<al.size();i++){
					GoodsBean gb=(GoodsBean)al.get(i);
					sm.addBatch("insert into orderDetail values('"+orderId+"','"+gb.getGoodsId()
							+"','"+mbo.getGoodsNumById(gb.getGoodsId()+"")+"')");
					//Statement����������ӵ����ݿ�ķ���
				}
				//����ִ��
				sm.executeBatch();
				//����ѯ
				String sql="select ordersId ,truename,address,postcode,phone,totalPrice,username,email from users,orders"+
				" where ordersId=? and users.userid =(select orders.uesrid from orders where ordersId=?)";
				ps=ct.prepareStatement(sql);
				ps.setInt(1, orderId);
				ps.setInt(2, orderId);
				rs=ps.executeQuery();
				if(rs.next()){
					//��re��װ��OrderInfoBean
					oib.setOrdersId(rs.getInt(1));
					oib.setTruename(rs.getString(2));
					oib.setAddress(rs.getString(3));
					oib.setPostcode(rs.getString(4));
					oib.setPhone(rs.getString(5));
					oib.setTotalPrice(rs.getFloat(6));
					oib.setUsername(rs.getString(7));
					oib.setEmail(rs.getString(8));
				}
			}
			
		}catch(Exception e){
			b=false;
			e.printStackTrace();
		}finally{
			DBUTil.close(ct);
		}		
		if(b){
			return oib;
		}else{
			return null;
		}
		
	}
}
