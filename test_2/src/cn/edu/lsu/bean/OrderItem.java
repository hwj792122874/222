package cn.edu.lsu.bean;

public class OrderItem {

	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", p=" + p + ", buynum=" + buynum + "]";
	}

	private Order order;
	private Products p;
	private int buynum;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Products getP() {
		return p;
	}

	public void setP(Products p) {
		this.p = p;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

}
