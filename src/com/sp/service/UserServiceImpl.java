//package com.sp.service;
//
//import com.sp.model.GoodsDAO;
//import com.sp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///*
//getBean的默认名称是类名（头字母小写），如果想自定义，可以@Service(“aaaaa”)这样来指定，这种bean默认是单例的，括号里面是名称
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//	//使用接口UserDAO声明对象，
//	@Autowired
//	GoodsDAO goodsDAO;
//
//	//实现接口中的login方法
//	@Override
//	public boolean login(String loginName, String loginPwd) {
//		return goodsDAO.login(loginName, loginPwd);
//	}
//
//}
