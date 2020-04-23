<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增商品</title>
   

  </head>
  
   <body bgcolor="#CDCFFF">
   <center>
   <h1>请输入商品信息</h1>
   <form action="users?flag=add" method="post">
   <table border="1">
   <tr><td bgcolor="pink">商品名</td><td><input type="text" name="goodsname"/></td></tr>
   <tr><td bgcolor="pink">商品类型</td><td><input type="text" name="goodstype"/></td></tr>
  
   </table><br>
   <input type="submit" value="添加商品"/>&nbsp&nbsp
   <input type="reset" value="重置"/>
   </form>
    </center>
      </body>
</html>
