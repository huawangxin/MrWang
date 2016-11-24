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
		//������ɶ������Ѷ���д�����ݿ⣩
		//�����񽻸�OrderBeanBO
		OrderBeanBO obb=new OrderBeanBO();
		//�õ����ﳵ
		MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
		//�û�id
		long userId=((UserBean)request.getSession().getAttribute("userInfo")).getUserid();
		try{
		OrderInfoBean oib=obb.addOrder(mcb, userId+"");
		if(oib!=null){
			//��ӳɹ�
			//׼�����������ݣ����¸�ҳ��
			request.setAttribute("detailbean", oib);
			
			request.getRequestDispatcher("shopping4.jsp").forward(request, response);
		}else{			
			ArrayList al=mcb.showMyCart();
			//��al����request
			request.setAttribute("mycartInfo", al);
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
