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
		//得到type，判断
		String type=request.getParameter("type");
		if(type.equals("showDetail")){
		//得到要显示货物的id号
		String goodsId=request.getParameter("id"); 
		//调用GoodsBeanBO 得到货物的具体信息
		GoodsBeanBO  gbb=new GoodsBeanBO();
		GoodsBean gb=gbb.getGoodsBean(goodsId);
		//把gb放入request
		request.setAttribute("goodsInfo",gb);
		//跳转
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
		}else if(type.equals("fenye")){
			
			//得到pageNow
			String pageNow=request.getParameter("pageNow");
			//把pageNow放入request
			request.setAttribute("abc",pageNow);
			// 跳回购物大厅
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}}
}
