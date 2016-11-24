package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class ShowGoodsClServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try{
		//�õ�type���ж�
		String type=request.getParameter("type");
		if(type.equals("showDetail")){
		//�õ�Ҫ��ʾ�����id��
		String goodsId=request.getParameter("id"); 
		//����GoodsBeanBO �õ�����ľ�����Ϣ
		GoodsBeanBO  gbb=new GoodsBeanBO();
		GoodsBean gb=gbb.getGoodsBean(goodsId);
		//��gb����request
		request.setAttribute("goodsInfo",gb);
		//��ת
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
		}else if(type.equals("fenye")){
			
			//�õ�pageNow
			String pageNow=request.getParameter("pageNow");
			//��pageNow����request
			request.setAttribute("abc",pageNow);
			// ���ع������
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}}
}
