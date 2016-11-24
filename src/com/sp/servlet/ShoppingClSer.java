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
		//�õ�typeֵ��
		String type=request.getParameter("type");
		try{
		MyCartBO mbo=(MyCartBO)request.getSession().getAttribute("mycart");
		if(mbo==null){
			//���û���һ�ι���
			 mbo=new MyCartBO();
			request.getSession().setAttribute("mycart", mbo);
		}
		if(type.equals("addGoods")){
		
		//��ù�������id
		String goodsId=request.getParameter("goodsId");
		//����MyCartBO[���ﳵ]����ɹ���
	//	MyCartBO mbo=new MyCartBO();    //��ֻ֤��һ�����ﳵ
		//session���
		
	
		mbo.addGoods(goodsId,"1");  //ÿ�ι���1����
	
		}else if(type.equals("delGoods")){
			//�õ�ɾ�������id
			String goodsId=request.getParameter("goodsId");
			//�ӹ��ﳵ��ɾ��
			mbo.delGoods(goodsId);
		}else if(type.equals("show")){
			//donothing
		}else if(type.equals("delAll")){
			mbo.clear();
		}else if(type.equals("updateGoods")){
			//�û��޸�����
			 // ʹ�����ر���ȡid
			//���ջ����id
			String goodsId[]=request.getParameterValues("goodsId");
			String newNums[]=request.getParameterValues("newNums");
			for(int i=0;i<goodsId.length;i++){
			
			mbo.upGoods(goodsId[i], newNums[i]);
			
			}
		}
		//�ѹ��ﳵ�Ļ���ȡ��������һҳ����ʾ
		ArrayList al=mbo.showMyCart();
		request.setAttribute("mycartinfo",al);
		//��ת
		request.getRequestDispatcher("showMycart.jsp").forward(request, response);
	}catch (Exception e) {
		e.printStackTrace();
	}}

}
