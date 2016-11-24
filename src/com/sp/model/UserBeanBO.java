/**
 * model,处理与users表的操作
 */
package com.sp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBeanBO {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	public void addBean(UserBean users) throws Exception{
		UserBean ub=new UserBean();
		try{
			ct=DBUTil.getConnection();   
			ps=ct.prepareStatement(
			"insert into users_wangxin values(?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, users.getUserid());
			ps.setString(2, users.getUsername());
			ps.setString(3, users.getTruename());
			ps.setString(4, users.getPasswd());
			ps.setString(5, users.getEmail());
			ps.setString(6, users.getPhone());
			ps.setString(7, users.getAddress());
			ps.setString(8, users.getPostcode());
			ps.setInt(9, users.getGrade());
			rs=ps.executeQuery();
			if(rs.next()){
				ub.setUserid(rs.getLong(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostcode(rs.getString(8));
				ub.setGrade(rs.getInt(9));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUTil.close(ct);
		}
	}
	public UserBean getUserBean(String u) throws Exception{
		UserBean ub=new UserBean();
		try{
			ct=DBUTil.getConnection();   
			ps=ct.prepareStatement("select * from users_wangxin where username=?");
			ps.setString(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				ub.setUserid(rs.getLong(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostcode(rs.getString(8));
				ub.setGrade(rs.getInt(9));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUTil.close(ct);
		}
		return ub;
	}
	
	public boolean checkUser(String u,String p) throws Exception{
		boolean b=false;
		try{
			//sql注入验证
			ct=DBUTil.getConnection();  
			ps=ct.prepareStatement("select passwd from users_wangxin where username=?");
			ps.setString(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				//取出数据库的密码
				String dbPasswd=rs.getString(1);
				if(dbPasswd.equals(p)){
					b=true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUTil.close(ct);
		}
		return b;
	}
}
