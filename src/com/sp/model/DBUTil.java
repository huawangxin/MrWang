package com.sp.model;
import java.sql.*;
public class DBUTil {
	public static Connection getConnection() throws Exception{
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tarena","tarena");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	public static void close(Connection conn) throws Exception{
		if(conn!=null){
			try{
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
//	public static void main(String[] args) {
//		try {
//			new DBUTil().getConnection();
//			System.out.println("创建成功");
//		} catch (Exception e) {
//			System.out.println("创建失败");
//			e.printStackTrace();
//		}
//	}
}
