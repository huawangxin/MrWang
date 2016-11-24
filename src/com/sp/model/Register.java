package com.sp.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.model.*;

public class Register extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//得到用户名和密码，验证
		int userid=2;
		String username=request.getParameter("username");
		String truename=request.getParameter("truename");
		String passwd=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String postcode=request.getParameter("postcode");
		int grade=1;
		UserBeanBO ubb=new UserBeanBO();
		try {
			UserBean user=new UserBean(
					userid, username, truename, passwd, 
					email, phone, address, postcode, grade);
			new UserBeanBO().addBean(user);
			if(ubb.checkUser(username,passwd)){
				//1.把成功登陆的用户所有信息放入session
				UserBean ub=ubb.getUserBean(username);
				request.getSession().setAttribute("userInfo", ub);
				//2.把购物车的信息取出
				MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
				ArrayList<GoodsBean> al=mcb.showMyCart();
				//把al放入request
				request.setAttribute("mycartInfo", al);

				//用户合法
				request.getRequestDispatcher("shopping3.jsp").forward(request, response);

			}else{
				//用户不合法
				request.getRequestDispatcher("shopping2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
