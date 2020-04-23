package com.sp.model;

import java.util.List;

public interface GoodsDAO {
	//添加商品
	public int addGoods(GoodsBean goodsbean);
	//修改商品
	public int updateGoods(GoodsBean goodsbean);
	//删除商品
	public int delGoodsById(Long goodsid);

	//通过id查询单个商品
	public GoodsBean findGoodsById(Long goodsid);
	//查询所有商品
	public List<GoodsBean> findAllGoods();

   public void transfer();


//	 boolean addGoods(GoodsBean userbean);
//	 boolean updateGoods(GoodsBean userbean);
//	 boolean delGoodsById(Long id);
//	 boolean login(String username, String password);
//	 ArrayList getGoods();
}
