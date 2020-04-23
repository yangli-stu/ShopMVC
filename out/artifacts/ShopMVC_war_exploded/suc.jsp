<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成功页面</title>
 

  </head>
  
  <body bgcolor="#CDCFFF">
   <center>
   <h1>恭喜你，操作成功！！</h1>
   <a href="welajax.jsp">返回管理界面</a>
   <hr>
    </center>
  </body>
</html>
