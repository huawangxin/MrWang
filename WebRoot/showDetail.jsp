<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//取出要显示的信息
GoodsBean gb=(GoodsBean)request.getAttribute("goodsInfo");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宝贝详情页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">
	<script type="text/javascript">
	<!-- 
		function returnHall(){
		   window.open("index.jsp","_self");
		}
		//响应点击购买货物事件
		function addGoods(goodsId){
		    //向ShoppingClSer请求添加货物
		     window.open("ShoppingClSer?type=addGoods&goodsId="+goodsId,"_self");
		}
		
	-->
	</script>

  </head>
  
  <body topmargin="0" background="images/bg.jpg">
  <center>
   <table width="80%" class="abc" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      <jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td height="316" align="center"><table class="abc" width="100%" height="313" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td height="26" colspan="2">&nbsp;</td>
        </tr>
      <tr>
        <td width="25%" rowspan="8"><img src="images/<%=gb.getPhoto() %>" width="132" height="161" /></td>
        <td width="75%" align="center"><%=gb.getGoodsName() %></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="21">价格：￥<%=gb.getGoodsPrice() %></td>
      </tr>
      <tr>
        <td height="19">&nbsp;</td>
      </tr>
      <tr>
        <td height="19">编号:<%=gb.getGoodsId() %></td>
      </tr>
      <tr>
        <td height="23">类型：<%=gb.getType() %></td>
      </tr>
      <tr>
        <td height="25">手机品牌：<%=gb.getPublisher() %></td>
      </tr>
      <tr>
        <td height="92" align="left" valign="top"><%=gb.getGoodsIntro() %></td>
      </tr>
      <tr>
        <td height="30" colspan="2"><input type="button" onclick="addGoods(<%=gb.getGoodsId() %>)" name="Submit" value="购买" />
          <input type="button" name="Submit2" onclick="returnHall();" value="返回购物大厅" /></td>
        </tr>
      <tr>
        <td height="26" colspan="2">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
      <jsp:include page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
</center>
  </body>
</html>
