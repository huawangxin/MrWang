<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="abc">
  <tr>
    <td align="center"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr align="center">
        <td><img src="images/11.jpg" width="120" height="168" /></td>
      </tr>
      <tr align="center">
        <td colspan="3"><img src="images/gougou.gif" width="155" height="90" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#FF99CC">&nbsp;</td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr align="center">
        <td colspan="3"><img src="images/gougou.gif" width="155" height="53" /></td>
        </tr>
      <tr align="center">
        <td>排行榜</td>
        <td>商品名称</td>
        <td>点击次数</td>
      </tr>
      <tr align="center">
        <td>1</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=1">iPhone 5s</a></td>
        <td>10</td>
      </tr>
      <tr align="center">
        <td>2</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=2">iPhone 6 Plus</a></td>
        <td>9</td>
      </tr>
      <tr align="center">
        <td>3</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=3">ZTE 中兴 V5S</a></td>
        <td>8</td>
      </tr>
      <tr align="center">
        <td>4</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=6">华为 荣耀6 H60-L02</a></td>
        <td>7</td>
      </tr>
      <tr align="center">
        <td>5</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=12">Nokia 诺基亚 1050</a></td>
        <td>6</td>
      </tr>
      <tr align="center">
        <td>6</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=8">华为荣耀 畅玩4X （Che1-CL10）</a></td>
        <td>5</td>
      </tr>
      <tr align="center">
        <td>7</td>
        <td><a href="ShowGoodsClServlet?type=showDetail&id=11">红米Note 标准版</a></td>
        <td>4</td>
      </tr>
    </table></td>
  </tr>
</table>