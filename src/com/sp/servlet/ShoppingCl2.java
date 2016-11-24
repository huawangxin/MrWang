package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class ShoppingCl2 extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//处理乱码
		PrintWriter out = response.getWriter();
		//检测用户是否登录过，没有则进入登陆界面，否则直接跳转
		try{
		//1.看session是否有用户登录的信息
		UserBean ub=(UserBean)request.getSession().getAttribute("userInfo");
		if(ub==null){
			//用户没有登录
			//跳转到shopping2.jsp
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
	}else{
		MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
		ArrayList al=mcb.showMyCart();
		//把al放入request
		request.setAttribute("mycartInfo", al);
		request.getRequestDispatcher("shopping3.jsp").forward(request, response);
	}
	}catch (Exception e) {
		e.printStackTrace();
	}
}}
