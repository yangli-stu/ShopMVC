//package com.sp.controller;
//
//import java.io.IOException;
//
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.sp.model.*;
//
///**
// * @author 不一样的汪
// */
//@WebServlet("/users")
//public class GoodsServlet extends HttpServlet{
//	@Override
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		//转换编码
//		request.setCharacterEncoding("utf-8");
//		//获取标志位
//		String flag=request.getParameter("flag");
//		/*
//		 * 处理增删改查
//		 */
//		if(flag.equals("all"))
//		{
//
//			try{
//				GoodsDAO goodsDAO=new GoodsDAOImpl();
//				//获取用户列表
//				ArrayList allGoods=goodsDAO.getGoods();
//
//				/*
//				 * 非AJAX方式
//				 */
////				request.setAttribute("result", allUsers);
////				//返回wel.jsp文件
////				request.getRequestDispatcher("wel.jsp").forward(request,response);
////
//				/* TODO
//				 *  JSON
//				 * 1. 设置返回的媒体格式
//				 * 2. 设置返回的编码
//				 * 3. 用GSON把对象序列化成JSON字符串
//				 * 4. 返回结果
//				 */
//				response.setContentType("text/html;charset=UTF-8");
//		        response.setCharacterEncoding("UTF-8");
//		        PrintWriter out = response.getWriter();
//		        String allGoodsString = new Gson().toJson(allGoods);
//		        out.print(allGoodsString);
//		        out.flush();
//
//			}catch(Exception e){
//			e.printStackTrace();
//			}
//		}else if(flag.equals("del")){
//			String goodsid=request.getParameter("goodsid");
//			GoodsDAO goodsDAO=new GoodsDAOImpl();
//			response.setContentType("text/html;charset=UTF-8");
//	        response.setCharacterEncoding("UTF-8");
//	        PrintWriter out = response.getWriter();
//
//			if(goodsDAO.delGoodsById(Long.parseLong(goodsid))){
//				 String result = new Gson().toJson(true);
//			        out.print(result);
//			        out.flush();
//			}else{
//				String result = new Gson().toJson(false);
//		        out.print(result);
//		        out.flush();
//			}
//		}else if(flag.equals("add")){
//			//获取传入的值
//			String name=request.getParameter("goodsname");
//			String type=request.getParameter("goodstype");
//
//			//测试是否获取到参数     	System.out.print(name+type+"这里是add方法");
//
//			GoodsBean goodsBean = new GoodsBean();
//			goodsBean.setGoodsname(name);
//			goodsBean.setGoodstype(type);
//
//	//测试		System.out.print("goodsBean.goodname取值："+goodsBean.getGoodsname()+"这里验证是否取值给goodsBean");
//
//			GoodsDAO goodsDAO=new GoodsDAOImpl();
//			response.setContentType("text/html;charset=UTF-8");
//	        response.setCharacterEncoding("UTF-8");
//	        PrintWriter out = response.getWriter();
//	        /*
//	         * 新增用户
//	         */
//			if(goodsDAO.addGoods(goodsBean)){
//		        String result = new Gson().toJson(true);
//		        out.print(result);
//		        out.flush();
//			}else {
//		        String result = new Gson().toJson(false);
//		        out.print(result);
//		        out.flush();
//			}
//
////
////			if(userDAO.addUser(userBean)){
////				request.getRequestDispatcher("suc.jsp").forward(request,response);//�ɹ�
////			}else{
////				request.getRequestDispatcher("err.jsp").forward(request,response);//ʧ��
////			}
//		}else if(flag.equals("update")){
//			//修改用户
//			String id=request.getParameter("goodsid");
//			String name=request.getParameter("goodsname");
//			String type=request.getParameter("goodstype");
//			GoodsBean goodsBean = new GoodsBean();
//			goodsBean.setGoodsid(Long.parseLong(id));
//			goodsBean.setGoodsname(name);
//			goodsBean.setGoodstype(type);
//			GoodsDAO goodsDAO=new GoodsDAOImpl();
//			response.setContentType("text/html;charset=UTF-8");
//	        response.setCharacterEncoding("UTF-8");
//	        PrintWriter out = response.getWriter();
//			if(goodsDAO.updateGoods(goodsBean)){
//				    String result = new Gson().toJson(true);
//			        out.print(result);
//			        out.flush();
//			}else{
//				String result = new Gson().toJson(false);
//		        out.print(result);
//		        out.flush();
//			}
//		}
//	}
//
//	/**
//	 * The doPost method of the servlet. <br>
//	 *
//	 * This method is called when a form has its tag value method equals to post.
//	 *
//	 * @param request the request send by the client to the server
//	 * @param response the response send by the server to the client
//	 * @throws ServletException if an error occurred
//	 * @throws IOException if an error occurred
//	 */
//	@Override
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		   //合二为一
//		this.doGet(request, response);
//	}
//
//}
