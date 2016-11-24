<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="css/my.css">
<!-- 只把table引入即可-->
<table width="100%" height="187" border="0" cellpadding="0" cellspacing="0" class="abc">
  <tr>
    <td height="10" colspan="3" bgcolor="#FF9999"></td>
  </tr>
  <tr>
  
    <td width="32%" height="115"><img src="images/logo1.jpg" width="193" height="113" /></td>
    <td width="50%"><img src="images/logo2.jpg" width="309" height="107" /></td>
    <td width="18%"><p class="abc"><a href="ShoppingCl2">【亲，请登录】</a></p>
    <p class="abc"><a href="ShoppingClSer?type=show">【我的购物车】</a></p></td>
  </tr>
  <tr>
    <td height="10" colspan="3" bordercolor="#FFFFFF" bgcolor="#FF9999"></td>
  </tr>
  <tr class="navi">
    <td height="29" colspan="3" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="11%" height="27">&nbsp;</td>
        <td width="11%" align="center" class="navi"><span class="abc"><a href="index.jsp">首页</a></span></td>
        <td width="11%">&nbsp;</td>
        <td width="11%" align="center" class="navi"><span class="abc">国外市场</span></td>
        <td width="11%">&nbsp;</td>
        <td width="11%" align="center" class="navi"><span class="abc">大陆市场</span></td>
        <td width="11%">&nbsp;</td>
        <td width="11%" align="center" class="navi"><span class="abc"><a href="tail.jsp">关于我们</a></span></td>
        <td width="11%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>