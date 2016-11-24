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
		//��������
		PrintWriter out = response.getWriter();
		//����û��Ƿ��¼����û��������½���棬����ֱ����ת
		try{
		//1.��session�Ƿ����û���¼����Ϣ
		UserBean ub=(UserBean)request.getSession().getAttribute("userInfo");
		if(ub==null){
			//�û�û�е�¼
			//��ת��shopping2.jsp
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
	}else{
		MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
		ArrayList al=mcb.showMyCart();
		//��al����request
		request.setAttribute("mycartInfo", al);
		request.getRequestDispatcher("shopping3.jsp").forward(request, response);
	}
	}catch (Exception e) {
		e.printStackTrace();
	}
}}
