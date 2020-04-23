package com.sp.controller;



import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 不一样的汪
 */
@Controller("loginController")
public class LoginServlet {

	@Autowired
	UserService userService;

	public boolean login(String loginName, String loginPwd) {
		return userService.login(loginName, loginPwd);
	}
}



























/*
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
      
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");  

		 String goodsname=request.getParameter("username");
		 String goodstype=request.getParameter("password");
		 GoodsDAO goodsDAO=new GoodsDAOImpl();
		 if(goodsDAO.checkUser(goodsname, goodstype)){

			 ArrayList al=goodsDAO.getGoods();
			 request.setAttribute("result", al);

		//	 request.getSession().setAttribute("myName",goodsname);
			 
			 request.getRequestDispatcher("welajax.jsp").forward(request,response);
		 }else{
			 request.getRequestDispatcher("login.jsp?err2=1").forward(request,response);			 
		 }		 
		 
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */

/*
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //�϶�Ϊһ
		this.doGet(request,response);
		
	}

	
}

*/
