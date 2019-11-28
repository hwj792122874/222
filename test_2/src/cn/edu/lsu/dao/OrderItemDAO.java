package cn.edu.lsu.dao;

import java.util.List;

import cn.edu.lsu.bean.Order;
import cn.edu.lsu.bean.OrderItem;


public interface OrderItemDAO {

	//根据订单查找订单项.并将订单项中商品查找到。
	public List<OrderItem> findOrderItemByOrder(final Order order);
	// 添加订单项
	public void addOrderItem(Order order);
	//根据订单id删除订单项
	public void delOrderItems(String id);
}
