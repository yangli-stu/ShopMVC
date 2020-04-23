<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改商品</title>
    
  </head>
  
 <body bgcolor="#CDCFFF">
   <center>
   <h1>修改商品信息</h1>
   <form action="users?flag=update" method="post">
   <table border="1">
   <tr>
	   <td bgcolor="pink">商品ID</td>
	   <td><input type="text" readonly="readonly" name="goodsid" value="<%=request.getParameter("goodsid")%>"/></td>
   </tr>
   <tr>
	   <td bgcolor="silver">商品名称</td>
	   <td><input type="text" name="goodsname" value="<%=request.getParameter("goodsname") %>"/></td>
   </tr>
   <tr>
	   <td bgcolor="pink">商品类型</td>
	   <td><input type="text" name="goodstype" value="<%=request.getParameter("goodstype") %>"/></td>
   </tr>  
   </table><br>
   <input type="submit" value="修改用户"/>&nbsp&nbsp
   <input type="reset" value="重置"/>
   </form>
    </center>
      </body>
</html>
