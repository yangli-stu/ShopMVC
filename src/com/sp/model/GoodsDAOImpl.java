package com.sp.model;    //接口实现类，封装对商品表的各种操作（增，删，改）

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class GoodsDAOImpl implements GoodsDAO{

	//声明JdbcTemplate属性及其setter方法
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//添加商品

	public int addGoods(GoodsBean goodsbean) {
		String sql="insert into goods(goodsname,goodstype) values(?,?)";
		//使用数组来存储SQL语句中的参数
		Object[] object=new Object[] {goodsbean.getGoodsname(),goodsbean.getGoodstype()};
		//执行添加操作，返回的是受影响的记录条数
		int result= jdbcTemplate.update(sql,object);
		return result;
	}

	//修改商品的实现方法

	public int updateGoods(GoodsBean goodsbean) {
		String sql="update goods set goodsname=?,goodstype=? where goodsid=?";
		//使用数组来存储SQL语句中的参数
		Object[] params=new Object[] {goodsbean.getGoodsname(),goodsbean.getGoodstype(),goodsbean.getGoodsid()};
		//执行修改操作，返回的是受影响的记录条数
		int result= jdbcTemplate.update(sql,params);
		return result;
	}
	//根据Id删除商品的实现方法

	public int delGoodsById(Long goodsid) {
		String sql="delete from goods where goodsid=?";
		//执行删除操作，返回的是受影响的记录条数
		int result=jdbcTemplate.update(sql,goodsid);
		return result;
	}
	//通过id查询单个商品的实现方法

	public GoodsBean findGoodsById(Long goodsid) {
		//定义单个查询的SQL语句
		String sql="select * from goods where goodsid=?";
		//创建一个新的BeanPropertyRowMapper对象，将结果集通过Java的反射机制映射到Java对象中
		RowMapper<GoodsBean> rowMapper=new BeanPropertyRowMapper<GoodsBean>(GoodsBean.class);
		//将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的对象
		return this.jdbcTemplate.queryForObject(sql, rowMapper,goodsid);
	}
	//查询所有商品的实现方法


//	@Transactional(propagation = Propagation.REQUIRED,
//			isolation = Isolation.DEFAULT, readOnly = false)
	public List<GoodsBean> findAllGoods() {
		//查询所有用户的SQL语句
		String sql="select * from goods";
		//创建一个新的BeanPropertyRowMapper对象
		RowMapper<GoodsBean> rowMapper=new BeanPropertyRowMapper<GoodsBean>(GoodsBean.class);
		//执行静态的SQL查询，并通过RowMapper返回List集合类型的结果
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Transactional(propagation = Propagation.REQUIRED,
			isolation = Isolation.DEFAULT, readOnly = false)
	public void transfer() {
		System.out.println("商品");
	}

}
