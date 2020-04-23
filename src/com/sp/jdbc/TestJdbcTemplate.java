package com.sp.jdbc;


import com.sp.model.GoodsBean;
import com.sp.model.GoodsDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TestJdbcTemplate {
    public static void main(String[] args) {
        //初始化Spring容器，加载applicationContext.xml文件
        ApplicationContext ctx= new ClassPathXmlApplicationContext("jdbcXML.xml");
        //通过容器获取JdbcTemplate的实例
        JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");

        //定义SQL语句
//        String sql="create table user(id int primary key auto_increment, userName varchar(20),password varchar(32))";
//        //使用execute()方法执行SQL语句创建一个user用户表
//        jdbcTemplate.execute(sql);

        System.out.println("JdbcTemplate实例化完成");
    }

    @Test
    public void addGoodsTest() {
        //初始化Spring容器，加载applicationContext.xml文件
        ApplicationContext ctx= new ClassPathXmlApplicationContext("jdbcXML.xml");
        //通过容器获取GoodsDAO的实例
        GoodsDAO goodsdao=(GoodsDAO) ctx.getBean("GoodsDAO");
        //创建GoodsBean对象，并向goodsbean中添加数据
        GoodsBean goodsbean=new GoodsBean();
        goodsbean.setGoodsname("苹果");
        goodsbean.setGoodstype("水果");
        //执行addGoods方法，并获取返回结果
        int result=goodsdao.addGoods(goodsbean);
        if (result>0) {
            System.out.println("成功向数据表中插入了 "+result+" 条记录！");
        }else {
            System.out.println("往数据表中插入数据失败！");
        }
    }

    @Test
    public void updateGoodsTest() {
        //初始化Spring容器，加载applicationContext.xml文件
        ApplicationContext ctx= new ClassPathXmlApplicationContext("jdbcXML.xml");
        //通过容器获取GoodsDAO的实例
        GoodsDAO goodsdao=(GoodsDAO) ctx.getBean("GoodsDAO");
        //创建GoodsBean对象，并向goodsbean中添加数据
        GoodsBean goodsbean=new GoodsBean();
        goodsbean.setGoodsid((long) 1);
        goodsbean.setGoodsname("小熊饼干");
        goodsbean.setGoodstype("零食");
        //执行updateGoods方法，并获取返回结果
        int result=goodsdao.updateGoods(goodsbean);
        if (result>0) {
            System.out.println("成功修改了 "+result+" 条记录！");
        }else {
            System.out.println("修改操作执行失败！");
        }
    }

    @Test
    public void delGoodsTest() {
        //初始化Spring容器，加载applicationContext.xml文件
        ApplicationContext ctx= new ClassPathXmlApplicationContext("jdbcXML.xml");
        //通过容器获取GoodsDAO的实例
        GoodsDAO goodsdao=(GoodsDAO) ctx.getBean("GoodsDAO");
        //执行deleteUser方法，并获取返回结果
        int result=goodsdao.delGoodsById((long) 1);
        if (result>0) {
            System.out.println("成功删除了 "+result+" 条记录！");
        }else {
            System.out.println("删除操作执行失败！");
        }
    }

    @Test
    public void findGoodsByIdTest() {
        //初始化Spring容器，加载applicationContext.xml文件
        ApplicationContext ctx= new ClassPathXmlApplicationContext("jdbcXML.xml");
        //通过容器获取GoodsDAO的实例
        GoodsDAO goodsdao=(GoodsDAO) ctx.getBean("GoodsDAO");
        //执行findUserById方法，获取User对象
        GoodsBean goodsbean=goodsdao.findGoodsById((long)1);
        System.out.println(goodsbean);
    }

    @Test
    public void findAllGoodsTest() {
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

}
