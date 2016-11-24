<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中国购物1号店</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--引用css-->
	<link rel="stylesheet" type="text/css" href="css/my.css">
	
  </head>
  
  <body topmargin="0" background="images/bg.jpg" >
   <table width="88%" height="716" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="192" colspan="2" align="center">
    <jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td width="21%" height="424" align="center">
    <jsp:include page="left.jsp"></jsp:include>
    </td>
    <td width="79%" valign="top" align="center">
   <jsp:include page="right.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <jsp:include page="tail.jsp"></jsp:include>
    </td>
  </tr>
</table>
  </body>
</html>
