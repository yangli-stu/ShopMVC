<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Wel Ajax示例</title>
</head>
<body>
<center>
<h1>商品信息</h1>
<!-- 商品信息的表格 -->
<table border="1" id="table">

  </table>
  </center>
   <center>
   <br/>
   <br/>
  
   <!-- 商品信息的表单 -->
  <form action="" method="">
   <table border="1">
   <tr><td bgcolor="pink">商品ID</td><td><input type="text" name="goodsid" id="goodsid" readonly="readonly"/></td></tr>
   <tr><td bgcolor="pink">商品名称</td><td><input type="text" name="goodsname" id="goodsname"/></td></tr>
   <tr><td bgcolor="silver">商品类型</td><td><input type="text" name="goodstype" id="goodstype"/></td></tr>
  
   </table><br>
   <input type="submit" value="保存商品" id="submitBtn"/>&nbsp&nbsp
   <input type="reset" value="重置"/>
   </form>
   </center>
</body>

<script src='static/jquery-3.4.1.min.js'></script>
<script src='static/usermgr.js'></script>


</html>