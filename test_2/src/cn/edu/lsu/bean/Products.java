package cn.edu.lsu.bean;


import java.io.Serializable;

public class Products implements Serializable{
	
	
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", pnum=" + pnum + ", imgurl="
				+ imgurl + ", description=" + description + "]";
	}
	public Products(String id, String name, Double price, String category,
			int pnum, String imgurl, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.pnum = pnum;
		this.imgurl = imgurl;
		this.description = description;
	}
	public Products() {
		
		
	}
	
	private String id; // 商品编号
	private String name; // 名称
//	private String author; //作者
	private double price; // 价格
	private String category; // 分类
	private int pnum; // 数量
	private String imgurl; // 图片路径
	private String description; // 描述

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
