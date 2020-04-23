<%@ page language="java" import="com.sp.model.GoodsBean,java.util.ArrayList" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理页面</title>
    

  </head> 
  <body bgcolor="#CDCFFF">
  <%
      //防止用户非法登陆
      String u=(String)session.getAttribute("myName");
      //如果用户没有登录
      if(u==null){
      response.sendRedirect("login.jsp?err=1");
      return ;
      }
      
   %>
  <center>  
  登陆成功！恭喜你！<%=(String)session.getAttribute("myName")%><br>
  <a href="login.jsp">重新登陆</a>
  <h1>商品信息</h1>
   <a href="addGoods.jsp">新增商品</p>
  <%
  
    //从request中获取商品信息
    ArrayList al=(ArrayList)request.getAttribute("result");
  	if(null == al){
  		
  	}
   %>
   <table border="1">
   <tr bgcolor="pink"><td>商品ID</td><td>商品名称</td><td>商品类型</td>
   <td>修改商品</td><td>删除商品</td></tr>   
   <%
     //定义颜色数组
     String []color={"silver","pink"};
     for(int i=0;i<al.size();i++){
     GoodsBean ub=(GoodsBean)al.get(i);
   %>    
   <tr bgcolor="<%=color[i%2] %>">
	   <td ><%=ub.getGoodsid()%></td>
	   <td><%=ub.getGoodsname()%></td>
	   <td><%= ub.getGoodstype()%></td>
	   <td><a href="updateGoods.jsp?goodsname=<%=ub.getGoodsname()%>&goodstype=<%=ub.getGoodstype()%>&goodsid=<%=ub.getGoodsid()%>">修改商品</a></td>
	   <td><a  href="users?flag=del&goodsid=<%=ub.getGoodsid()%>">删除商品</a></td>
   </tr> 
   <% }%> 
  </table>
  </center>
  </body>
</html>
