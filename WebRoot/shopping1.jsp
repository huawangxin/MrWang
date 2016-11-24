<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册会员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/my.css">


  </head>
  
  <body topmargin="0" background="images/bg.jpg">
    <center>
    <table width="80%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    <jsp:include page="head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" height="165" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center"><img src="images/gouwuliucheng.gif" width="455" height="55" /></td>
      </tr>
      <tr>
        <td align="center">
       
        <form action="Register" method="post">
        
        <table width="40%" border="1" cellpadding="0" cellspacing="0" bordercolor="#66CC33" class="abc">
          <tr align="center">
            <td colspan="2"><img src="images/login.jpg" width="106" height="39" /></td>
            </tr>
          <tr>
            <td width="37%" align="right">用户名：</td>
            <td width="63%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td width="37%" align="right">真 名：</td>
            <td width="63%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td align="right">密 &nbsp;码：</td>
            <td align="left"><input name="password" type="password" size="15" /></td>
          </tr>
          <tr>
            <td width="37%" align="right">电子邮箱：</td>
            <td width="63%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td width="37%" align="right">联系电话：</td>
            <td width="63%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td width="37%" align="right">联系地址：</td>
            <td width="63%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td width="37%" align="right">寄件地址：</td>
            <td width="63%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="提交" />
            </td>
            <td align="left"><input type="reset" name="Submit2" value="重填" /></td>
          </tr>
        </table>
        </form>
        </td>
      </tr>
      <tr>
        <td height="46" align="right"><img src="images/xiayibu.jpg" width="73" height="28" /></td>
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
