package com.sp.model;

public class GoodsBean {
	private Long goodsid;
	private String goodsname;
	private String goodstype;
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}

	@Override
	public String toString() {
		return "User对象："+goodsid+" --- " +goodsname+" -- "+goodstype;
	}

}
