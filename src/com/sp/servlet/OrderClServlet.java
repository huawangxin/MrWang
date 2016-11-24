package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class OrderClServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//处理完成订单（把订单写入数据库）
		//该任务交给OrderBeanBO
		OrderBeanBO obb=new OrderBeanBO();
		//得到购物车
		MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
		//用户id
		long userId=((UserBean)request.getSession().getAttribute("userInfo")).getUserid();
		try{
		OrderInfoBean oib=obb.addOrder(mcb, userId+"");
		if(oib!=null){
			//添加成功
			//准备订单的数据，给下个页面
			request.setAttribute("detailbean", oib);
			
			request.getRequestDispatcher("shopping4.jsp").forward(request, response);
		}else{			
			ArrayList al=mcb.showMyCart();
			//把al放入request
			request.setAttribute("mycartInfo", al);
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
