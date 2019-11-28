package cn.edu.lsu.dao.impl;

import cn.edu.lsu.bean.Notice;
import cn.edu.lsu.bean.Order;
import cn.edu.lsu.bean.User;
import cn.edu.lsu.dao.OrderDAO;
import cn.edu.lsu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Order> findOrderByUser(User user) {
        return null;
    }

    @Override
    public Order findOrderById(String id) {
        String sql="select o.id ,o.money,o.receiverAddress,o.receiverName,o.receiverPhone,o.paystate,o.ordertime,u.*  from user u,orders o where u.id=o.user_id and o.id=?";
        return (Order) template.queryForObject(sql,new RowMapper(){
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order o=new Order();
                User u=new User();
                o.setId(rs.getString("o.id"));
                o.setMoney(rs.getInt("o.money"));
                o.setReceiverAddress(rs.getString("o.receiverAddress"));
                o.setReceiverName(rs.getString("o.receiverName"));
                o.setReceiverPhone(rs.getString("o.receiverPhone"));
                o.setPaystate(rs.getInt("o.paystate"));
                o.setOrdertime(rs.getDate("o.ordertime"));
                u.setId(rs.getInt("u.id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setGender(rs.getString("gender"));
                u.setEmail(rs.getString("email"));
                u.setTelephone(rs.getString("telephone"));
                u.setIntroduce(rs.getString("introduce"));
                u.setActiveCode(rs.getString("activeCode"));
                u.setRole(rs.getString("role1"));
                u.setState(rs.getInt("state"));
                u.setRegistTime(rs.getDate("registTime"));
                o.setUser(u);
                return o;
            }},id);

    }

    @Override
    public List<Order> findAllOrder() {
        String sql="select o.id ,o.money,o.receiverAddress,o.receiverName,o.receiverPhone,o.paystate,o.ordertime,u.*  from user u,orders o where u.id=o.user_id";
        List<Order> orders = template.query(sql, new RowMapper(){
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order o=new Order();
                User u=new User();
                o.setId(rs.getString("o.id"));
                o.setMoney(rs.getInt("o.money"));
                o.setReceiverAddress(rs.getString("o.receiverAddress"));
                o.setReceiverName(rs.getString("o.receiverName"));
                o.setReceiverPhone(rs.getString("o.receiverPhone"));
                o.setPaystate(rs.getInt("o.paystate"));
                o.setOrdertime(rs.getDate("o.ordertime"));
                u.setId(rs.getInt("u.id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setGender(rs.getString("gender"));
                u.setEmail(rs.getString("email"));
                u.setTelephone(rs.getString("telephone"));
                u.setIntroduce(rs.getString("introduce"));
                u.setActiveCode(rs.getString("activeCode"));
                u.setRole(rs.getString("role1"));
                u.setState(rs.getInt("state"));
                u.setRegistTime(rs.getDate("registTime"));
                o.setUser(u);
                return o;
            }});
        return orders;
    }

    @Override
    public List<Order> findOrderByManyCondition(String id, String receiverName) {
        String sql="select o.id ,o.money,o.receiverAddress,o.receiverName,o.receiverPhone,o.paystate,o.ordertime,u.*  from user u,orders o where u.id=o.user_id ";
        List param=new ArrayList();
        if (id!=null&&id.trim().length()>0){
            sql+=" and o.id =? ";
            param.add(id);
        }
        if (receiverName!=null&&receiverName.trim().length()>0){
            sql+=" and o.receiverName =? ";
            param.add(receiverName);
        }
        List<Order> orders = template.query(sql, new RowMapper(){
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Order o=new Order();
                User u=new User();
                o.setId(rs.getString("o.id"));
                o.setMoney(rs.getInt("o.money"));
                o.setReceiverAddress(rs.getString("o.receiverAddress"));
                o.setReceiverName(rs.getString("o.receiverName"));
                o.setReceiverPhone(rs.getString("o.receiverPhone"));
                o.setPaystate(rs.getInt("o.paystate"));
                o.setOrdertime(rs.getDate("o.ordertime"));
                u.setId(rs.getInt("u.id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setGender(rs.getString("gender"));
                u.setEmail(rs.getString("email"));
                u.setTelephone(rs.getString("telephone"));
                u.setIntroduce(rs.getString("introduce"));
                u.setActiveCode(rs.getString("activeCode"));
                u.setRole(rs.getString("role1"));
                u.setState(rs.getInt("state"));
                u.setRegistTime(rs.getDate("registTime"));
                o.setUser(u);
                return o;
            }},param.toArray());
        return orders;
    }

    @Override
    public void delOrderById(String id) {
        String sql="delete from orders where id=?";
        template.update(sql,id);

    }

    @Override
    public void addProduct(Order order) {

    }

    @Override
    public void updateOrderState(String id) {

    }
}
