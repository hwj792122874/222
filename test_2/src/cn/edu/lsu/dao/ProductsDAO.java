package cn.edu.lsu.dao;

import java.util.List;

import cn.edu.lsu.bean.Order;
import cn.edu.lsu.bean.OrderItem;
import cn.edu.lsu.bean.Products;



public interface ProductsDAO {
	
	//插入商品记录
	
	public int addProducts(Products products);
	
	
	//后台系统，根据id删除商品信息
	public int delProducts(String id);
	
	//查询所有商品记录
	
	public List<Products> queryAll();
	
	//查询指定商品
	public Products queryById(String id);
	
	// 修改商品信息
		public void editProduct(Products p);
	
	
	//多条件查询
	public List<Products> findProductByManyCondition(String id,
                                                     String category, String name, String minprice, String maxprice);
	
	//前台，获取本周热销商品
		public List<Products> getWeekHotProduct();

	// 生成订单时，将商品数量减少
		public void changeProductNum(Order order);
	//删除订单时，修改商品数量
		public void updateProductNum(List<OrderItem> items);
		//前台，用于搜索框根据书名来模糊查询相应的图书
		public List<Products> findBookByName(String searchfield);


}
