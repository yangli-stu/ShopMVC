package com.demo.po;
public class Goods {
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
		return "Goods{" +
				"goodsid=" + goodsid +
				", goodsname='" + goodsname + '\'' +
				", goodstype=" + goodstype +
				'}';
	}
}
