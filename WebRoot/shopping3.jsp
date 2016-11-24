<%@ page language="java" import="java.util.*,com.sp.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//得到用户信息
UserBean ub=(UserBean)session.getAttribute("userInfo");
//得到购物车的信息
ArrayList al=(ArrayList)request.getAttribute("mycartInfo");
//得到购物车
MyCartBO mcb=(MyCartBO)session.getAttribute("mycart");
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/my.css">	
<script type="text/javascript">
<!--	
 		window.alert("欢 迎 您  VIP 客 户");
 		
 -->
</script>
  </head>
  
  <body topmargin="0" background="images/bg.jpg">
   <center>
   <td align="center">
   <jsp:include page="head.jsp"></jsp:include>
   </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center"><img src="images/gouwuliucheng.gif" width="406" height="50" /></td>
      </tr>
      <tr>
        <td align="center"><table width="71%" border="1" cellpadding="0" cellspacing="0" class="abc">
          <tr>
            <td colspan="2" align="center">购买人的信息</td>
            </tr>
          <tr>
            <td width="50%" align="right">用户名：</td>
            <td width="50%"><input type="text" name="textfield" value="<%=ub.getUsername() %>" /></td>
          </tr>
          <tr>
            <td align="right">*真实姓名</td>
            <td><input type="text" name="textfield2" value="<%=ub.getTruename() %>"/></td>
          </tr>
          <tr>
            <td align="right">*家庭住址</td>
            <td><input type="text" name="textfield3" value="<%=ub.getAddress() %>"/></td>
          </tr>
          <tr>
            <td align="right">*联系电话</td>
            <td><input type="text" name="textfield4" value="<%=ub.getPhone() %>"/></td>
          </tr>
          <tr>
            <td align="right">*电子邮件</td>
            <td><input type="text" name="textfield5" value="<%=ub.getEmail() %>"/></td>
          </tr>
          <tr>
            <td align="right">*邮&nbsp;&nbsp;&nbsp; 编 </td>
            <td><input type="text" name="textfield6" value="<%=ub.getPostcode() %>"/></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="完成订单" /></td>
            <td><input type="submit" name="Submit2" value="修改个人信息" /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td align="center"><table width="71%" border="1" cellpadding="0" cellspacing="0" class="abc">
          <tr>
            <td colspan="4" align="center">我的购物车情况</td>
            </tr>
          <tr align="center">
            <td>编号</td>
            <td>商品名称</td>
            <td align="left">单价</td>
            <td align="left">数量</td>
          </tr>
         <%//显示购物车的信息
         for(int i=0;i<al.size();i++){
         GoodsBean gb=(GoodsBean)al.get(i);
         %>
         	<tr>
       		  <td align="center"><%=gb.getGoodsId() %></td>
       	     <td align="center"><%=gb.getGoodsName() %></td>
       	     <td><%=gb.getGoodsPrice() %></td>
       	      <td><%=mcb.getGoodsNumById(gb.getGoodsId()+"") %></td>
       	      </tr>
         <%
         }
          %>
          <tr align="center">
            <td colspan="4" align="left">您共选择了价值￥<%=mcb.getAllPrice() %>的商品</td>
            </tr>
          <tr align="center">
            <td colspan="4"><input type="submit" name="Submit3" value="修改我的购物车" /></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td align="right"><img border="0" src="images/shangyibu.gif" width="78" height="30" />&nbsp;
        <a href="OrderClServlet"><img border="0" src="images/xiayibu.jpg" width="100" height="31" /></a></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center">
     <jsp:include page="tail.jsp"></jsp:include>
    </td>
   </center>
  </body>
</html>
