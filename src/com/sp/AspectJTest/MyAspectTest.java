package com.sp.AspectJTest;

import com.sp.model.GoodsBean;
import com.sp.model.GoodsDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyAspectTest {
    @Test
    public void myAspectXMLTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("myAspectXML.xml");
        // 获取GoodsDao实例
        GoodsDAO goodsdao =
                (GoodsDAO)applicationContext.getBean("goodsDao");
        //执行findAllUser方法,获取User对象的集合
        List<GoodsBean> goodsbeans=goodsdao.findAllGoods();
        //循环输出集合中的对象
        for (GoodsBean goodsbean : goodsbeans) {
            System.out.println(goodsbean);
        }
//        goodsdao.transfer();
    }

    @Test
    public void jdbcXMLTest(){
        //初始化Spring容器，加载applicationContext.xml文件
        ApplicationContext ctx= new ClassPathXmlApplicationContext("jdbcXML.xml");
        //通过容器获取GoodsDAO的实例
        GoodsDAO goodsdao=(GoodsDAO) ctx.getBean("goodsDao");
        //执行findAllUser方法,获取User对象的集合
        List<GoodsBean> goodsbeans=goodsdao.findAllGoods();
        //循环输出集合中的对象
        for (GoodsBean goodsbean : goodsbeans) {
            System.out.println(goodsbean);
        }
    }



//    public static void main(String[] args){
//        //初始化Spring容器，加载myAspectXML.xml文件
//        ApplicationContext ctx= new ClassPathXmlApplicationContext("myAspectXML.xml");
//         GoodsDAO goodsDAO =(GoodsDAO) ctx.getBean("goodsDAO");
//         goodsDAO.findAllGoods();
//    }
}
