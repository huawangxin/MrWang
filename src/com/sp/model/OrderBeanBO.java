//这是model，对orders，orderDetail的处理
package com.sp.model;

import java.sql.*;
import java.util.ArrayList;

public class OrderBeanBO {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	
	//注释函数  及变量的声明
	/**
	 * 生成订单
	 * @param mbo 用户的购物车
	 * @param userId 用户id
	 * @return 返回订单详细信息bean
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
			int a=ps.executeUpdate();//更新成功  返回值
			if(a==1){
				//必须取出刚刚添加到orders表的订单
				//取出最后那条的orders的id 就是
				ps=ct.prepareStatement("select max(ordersId) from orders");
				rs=ps.executeQuery();
				int orderId=0;
				if(rs.next()){
					orderId=rs.getInt(1);
				}
				//orders 表添加成功
				//添加ordersDetail
				//从购物车取出所有选购的货物
				ArrayList al=mbo.showMyCart();
				//循环的添加到orderDetail表，会影响效率
				//使用批量操作数据库的方法，提高效率
		       Statement sm=ct.createStatement();
				for(int i=0;i<al.size();i++){
					GoodsBean gb=(GoodsBean)al.get(i);
					sm.addBatch("insert into orderDetail values('"+orderId+"','"+gb.getGoodsId()
							+"','"+mbo.getGoodsNumById(gb.getGoodsId()+"")+"')");
					//Statement中有批量添加到数据库的方法
				}
				//批量执行
				sm.executeBatch();
				//多表查询
				String sql="select ordersId ,truename,address,postcode,phone,totalPrice,username,email from users,orders"+
				" where ordersId=? and users.userid =(select orders.uesrid from orders where ordersId=?)";
				ps=ct.prepareStatement(sql);
				ps.setInt(1, orderId);
				ps.setInt(2, orderId);
				rs=ps.executeQuery();
				if(rs.next()){
					//将re封装到OrderInfoBean
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
