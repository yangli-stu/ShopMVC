<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>失败页面</title>

  </head>
  
  <body>
    <body bgcolor="#CDCFFF">
   <center>
   <hr>
   <h1>操作失败！！</h1>
   <a href="users?flag=all">返回管理界面</a>
   <hr>
    </center>
  </body>
  </body>
</html>
