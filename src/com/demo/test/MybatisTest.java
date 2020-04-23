package com.demo.test;

import com.demo.po.Goods;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

    /**
     * 1.根据商品编号查询商品信息
     */
    @Test
    public void findGoodsByIdTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        Goods goods = sqlSession.selectOne("com.demo.mapper"
                + ".GoodsMainMapper.findGoodsById", (long)1);
        // 打印输出结果
        System.out.println(goods.toString());
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 2.根据商品名称来模糊查询商品信息列表
     */
    @Test
    public void findGoodsByNameTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Goods> goods = sqlSession.selectList("com.demo.mapper"
                + ".GoodsMainMapper.findGoodsByName", "橙子");
        for (Goods good : goods) {
            //打印输出结果集
            System.out.println(good);
        }
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 3.添加商品
     */
    @Test
    public void addGoodsTest(){
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        Goods good = new Goods();
        good.setGoodsname("泡泡机");
       good.setGoodstype("玩具");
        // 使用主键自助增长的添加方法
//		int rows = sqlSession.insert("com.itheima.mappers."
//				+ "CustomerMapper.addCustomer", customer);
        // 使用自定义主键值的添加方法
        int rows = sqlSession.insert("com.demo.mapper."
                + "GoodsMainMapper.addGoods", good);
        // 输出插入数据的主键id值
        System.out.println(good.getGoodsid());
        if(rows > 0){
            System.out.println("您成功插入了"+rows+"条数据！");
        }else{
            System.out.println("执行插入操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * 4.更新商品
     */
    @Test
    public void updateGoodsTest() throws Exception{
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行更新操作
        // 创建Customer对象，并向对象中添加数据
        Goods good = new Goods();
        good.setGoodsid((long)18);
        good.setGoodsname("果汁");
        good.setGoodstype("饮料");
        // 执行sqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("com.demo.mapper"
                + ".GoodsMainMapper.updateGoods", good);
        // 通过返回结果判断更新操作是否执行成功
        if(rows > 0){
            System.out.println("您成功修改了"+rows+"条数据！");
        }else{
            System.out.println("执行修改操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }
    /**
     * 5.删除商品
     */
    @Test
    public void deleteGoodsTest() {
        // 获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSession();
        // SqlSession执行删除操作
        // 执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("com.demo.mapper"
                + ".GoodsMainMapper.deleteGoods", (long)18);
        // 通过返回结果判断删除操作是否执行成功
        if(rows > 0){
            System.out.println("您成功删除了"+rows+"条数据！");
        }else{
            System.out.println("执行删除操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }


    @Test
    public void findAllGoodsTest(){
        //获取SqlSession
        SqlSession sqlSession= MybatisUtils.getSession();
        //SqlSession执行映射文件中定义的SQL，并返回结果
        List<Goods> list = sqlSession.selectList("com.demo.mapper.GoodsMapper.findAllGoods");
        for (Goods goods : list){
            System.out.println(goods);
        }
        sqlSession.close();
    }

}
