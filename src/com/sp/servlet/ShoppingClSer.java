package com.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class ShoppingClSer extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//得到type值，
		String type=request.getParameter("type");
		try{
		MyCartBO mbo=(MyCartBO)request.getSession().getAttribute("mycart");
		if(mbo==null){
			//该用户第一次购物
			 mbo=new MyCartBO();
			request.getSession().setAttribute("mycart", mbo);
		}
		if(type.equals("addGoods")){
		
		//获得购买货物的id
		String goodsId=request.getParameter("goodsId");
		//调用MyCartBO[购物车]，完成购物
	//	MyCartBO mbo=new MyCartBO();    //保证只有一个购物车
		//session解决
		
	
		mbo.addGoods(goodsId,"1");  //每次购买1本书
	
		}else if(type.equals("delGoods")){
			//得到删除货物的id
			String goodsId=request.getParameter("goodsId");
			//从购物车中删除
			mbo.delGoods(goodsId);
		}else if(type.equals("show")){
			//donothing
		}else if(type.equals("delAll")){
			mbo.clear();
		}else if(type.equals("updateGoods")){
			//用户修改数量
			 // 使用隐藏表单获取id
			//接收货物的id
			String goodsId[]=request.getParameterValues("goodsId");
			String newNums[]=request.getParameterValues("newNums");
			for(int i=0;i<goodsId.length;i++){
			
			mbo.upGoods(goodsId[i], newNums[i]);
			
			}
		}
		//把购物车的货物取出，在下一页面显示
		ArrayList al=mbo.showMyCart();
		request.setAttribute("mycartinfo",al);
		//跳转
		request.getRequestDispatcher("showMycart.jsp").forward(request, response);
	}catch (Exception e) {
		e.printStackTrace();
	}}

}
