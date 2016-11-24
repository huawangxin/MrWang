package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class LoginCl extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//�õ��û��������룬��֤
		String u=request.getParameter("username");
		String p=request.getParameter("password");
System.out.println(u+":"+p);
		UserBeanBO ubb=new UserBeanBO();
		try{
		if(ubb.checkUser(u,p)){
			//1.�ѳɹ���½���û�������Ϣ����session
			UserBean ub=ubb.getUserBean(u);
			request.getSession().setAttribute("userInfo", ub);
			//2.�ѹ��ﳵ����Ϣȡ��
			MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
			ArrayList<GoodsBean> al=mcb.showMyCart();
			//��al����request
			request.setAttribute("mycartInfo", al);
System.out.println("�Ϸ�");	
			//�û��Ϸ�
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
	
		}else{
			//�û����Ϸ�
System.out.println("���Ϸ�");
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
		}}catch (Exception e) {
			e.printStackTrace();
		}}
}
		

