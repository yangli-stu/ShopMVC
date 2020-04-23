package com.sp.test;

import com.sp.controller.LoginServlet;
import com.sp.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.assertTrue;

/**
 * @author 不一样的汪
 */
public class SpringIDTest {

	@Test
	public void testAutoWired() {
		//初始化Spring容器，加载applicationContext.xml文件
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取UserServiceImpl中的实例
		LoginServlet loginservlet=(LoginServlet) ctx.getBean("loginController");
		boolean flag=loginservlet.login("张三", "345");

		assertTrue(flag);
	}

	@Test
	public void testNoNameService(){
		//初始化Spring容器，加载applicationContext.xml文件

		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取UserServiceImpl中的实例
		UserService userService=(UserService) ctx.getBean("userServiceImpl");
		boolean flag=userService.login("张三", "345");
		assertTrue(flag);
	}
}
