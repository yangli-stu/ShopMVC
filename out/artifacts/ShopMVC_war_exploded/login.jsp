<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<script type="text/javascript">
		function check(){
			if(form1.username.value==""){
			window.alert("用户名不能为空！");
			return false;
			}
			if(form1.passwd.value==""){
		    window.alert("密码不能为空！");
		    return false;
		 	}
		 	return true;
		}
	</script>
  </head> 
  <body bgcolor="#CDCFFF">
  <center>
  <%
  		String err=request.getParameter("err");
  		if(err!=null){
  			if(err.equals("1")){
  				out.println("用户没有正常登陆，请登录！！");
  		}
  		}
   %>
   <%
  		String err2=request.getParameter("err2");
  		if(err2!=null){
  			if(err2.equals("1")){
  	%>			
  	<script type="text/javascript">
  	window.alert("用户名或密码错误，请重新登录！！");
  	</script>
  	<%			
  		}
  		}
   %>
   <hr>
   <font color="red" size=6> 用户登录</font><br>
    <form name="form1" action="login" method="post">
	    用户名:<input type="text" name="username">
	    <br><br>
	    密&nbsp;&nbsp;码:<input type="password" name="password">
	    <br><br>
    <input type="submit" value="登录" onclick="return check()">
    <input type="reset" value="重置"><hr>
    </form>
    </center>
  </body>
</html>
