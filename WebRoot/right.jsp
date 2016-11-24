<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//使用GoodsBeanBO, 完成分页

GoodsBeanBO gbb=new GoodsBeanBO();
//接收pageNow
String s_pageNow=(String)request.getAttribute("abc");
int pageNow=1;
if(s_pageNow!=null){
 	pageNow=Integer.parseInt(s_pageNow);
}

//默认显示第一页
ArrayList al=gbb.getGoodsByPage(6,pageNow);
//得到共有多少页
int pageCount=gbb.getPageCount(6);

%>

<table class="abc" width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td colspan="3" align="center"><img src="images/shang.jpg" width="389" height="50" /></td>
  </tr>
  
  <%
  		int time=0;
  		for(int i=0;i<2;i++){
  		//打印两大行，每行三个，可能不够显示
  		%>
  		<tr>
  		<%
  			for(int j=0;j<3;j++){
  			GoodsBean gb=new GoodsBean();
  			if(time>=al.size()){
  			//不能再取
  				//默认一个
  				
  				gb.setGoodsId(0);
  				gb.setGoodsIntro("没有书了");
  				gb.setPhoto("gougou.gif");
  				gb.setGoodsPrice(0.0f);
  				gb.setGoodsName("无书");
  			}else{
  			
  			 gb=(GoodsBean)al.get(time);//??
  				time++;
  				}
  		%>
  		  <td width="33%" height="192" align="center"><table width="100%" height="190" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="48%" rowspan="3"><img src="images/<%=gb.getPhoto() %>" width="114" height="142" /></td>
        <td width="52%" height="52">&nbsp;</td>
      </tr>
      <tr>
        <td height="35"><a href="ShowGoodsClServlet?type=showDetail&id=<%=gb.getGoodsId() %>"><%=gb.getGoodsName() %></a></td>
      </tr>
      <tr>
        <td height="46" valign="top">价格： ￥<%=gb.getGoodsPrice() %> </td>
      </tr>
      <tr>
        <td height="40" colspan="2" valign="top">简单介绍：<%=gb.getGoodsIntro() %></td>
         </tr>
      </table></td>
  		<%
  			}
  		%>
  		</tr>
  		<%	
  		//判断第一行是否结束
  		if(i==0){
  		%>
  		<tr>
  		 <tr>
   		 <td colspan="3" align="center" bgcolor="#FF99CC">&nbsp;</td>
   		</tr>
  		<%
  		
  		}
  		
  		}
  			
  		
   %>
  
  
  
  <tr>
    <td colspan="3" align="center">
    <%
    	for(int i=1;i<=pageCount;i++){
    	
    	%>
    	<a href="ShowGoodsClServlet?type=fenye&pageNow=<%=i%>">【<%=i%>】</a>
    	<%
    	}
     %>
    </td>
  </tr>
</table>