package cn.edu.lsu.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.lsu.bean.Order;
import cn.edu.lsu.bean.User;

public interface OrderDAO {

	
	    //按照用户ID查找订单
	public List<Order> findOrderByUser(final User user);
		// 按ID查找订单
		public Order findOrderById(String id) ;
		// 查找 所有订单
		public List<Order> findAllOrder();
		// 多条件查询订单
		public List<Order> findOrderByManyCondition(String id, String receiverName);
		//删除订单
		public void delOrderById(String id);
		// 生成订单
		public void addProduct(Order order);
		// 更新订单状态
		public void updateOrderState(String id);
		
		
		
}
