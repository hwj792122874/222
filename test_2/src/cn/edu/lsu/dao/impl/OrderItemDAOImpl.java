package cn.edu.lsu.dao.impl;

import cn.edu.lsu.bean.Order;
import cn.edu.lsu.bean.OrderItem;
import cn.edu.lsu.bean.Products;
import cn.edu.lsu.bean.User;
import cn.edu.lsu.dao.OrderItemDAO;
import cn.edu.lsu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDAOImpl implements OrderItemDAO {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<OrderItem> findOrderItemByOrder(Order order) {
        String sql="select o.*,p.*,oi.buynum from orders o,products p,orderitem oi where oi.order_id=o.id and oi.product_id=p.id and o.id=?";
        List<OrderItem> orderItems = template.query(sql, new RowMapper(){
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order o=new Order();
                Products p=new Products();
                OrderItem oi=new OrderItem();
                oi.setBuynum(rs.getInt("oi.buynum"));
                p.setId(rs.getString("p.id"));
                p.setName(rs.getString("p.name"));
                p.setPrice(rs.getDouble("p.price"));
                p.setCategory(rs.getString("p.category"));
                p.setPnum(rs.getInt("p.pnum"));
                p.setImgurl(rs.getString("imgurl"));
                p.setDescription(rs.getString("description"));
                oi.setOrder(o) ;
                oi.setP(p);
                return oi;
            }},order.getId());
        return orderItems;

    }

    @Override
    public void addOrderItem(Order order) {

    }

    @Override
    public void delOrderItems(String id) {
        String sql="delete from orderitem where order_id=?";
        template.update(sql,id);


    }
}
