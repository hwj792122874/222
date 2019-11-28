package cn.edu.lsu.dao.impl;

import cn.edu.lsu.bean.Order;
import cn.edu.lsu.bean.OrderItem;
import cn.edu.lsu.bean.Products;
import cn.edu.lsu.bean.User;
import cn.edu.lsu.dao.ProductsDAO;
import cn.edu.lsu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ProductsDAOImpl implements ProductsDAO {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int addProducts(Products products) {
        String sql="insert into products(name,price,category,pnum,imgurl,description) values(?,?,?,?,?,?)";
        template.update(sql,products.getName(),products.getPrice(),products.getCategory(),products.getPnum(),products.getImgurl(),products.getDescription());
        return 0;
    }

    @Override
    public int delProducts(String id) {

        String sql="delete from products where id=?";
        template.update(sql,id);
        return 0;

    }

    @Override
    public List<Products> queryAll() {
            String sql="select * from products";
            List<Products> products = template.query(sql, new BeanPropertyRowMapper<Products>(Products.class));
            return products;
    }

    @Override
    public Products queryById(String id) {
        return null;
    }

    @Override
    public void editProduct(Products p) {
        String sql1="update products set name=?,price=?,category=?,pnum=?,imgurl=?,description=? where id=?";
        String sql2="update products set name=?,price=?,category=?,pnum=?,description=? where id=?";
        if (p.getImgurl()==null) {
            template.update(sql2, p.getName(), p.getPrice(), p.getCategory(), p.getPnum(),  p.getDescription(), p.getId());
        }else{
            template.update(sql1, p.getName(), p.getPrice(), p.getCategory(), p.getPnum(), p.getImgurl(), p.getDescription(), p.getId());
        }
    }

    @Override
    public List<Products> findProductByManyCondition(String id, String category, String name, String minprice, String maxprice) {
        String sql="select * from products where 1=1 ";
        List param=new ArrayList();
        if (id!=null&&id.trim().length()>0){
            sql+=" and id =? ";
            param.add(id);
        }
        if (category!=null&&category.trim().length()>0){
            sql+=" and category = ? ";
            param.add(category);
        }
        if (name!=null&&name.trim().length()>0){
            sql+=" and name = ? ";
            param.add(name);
        }
        if (minprice!=null&&minprice.trim().length()>0){
            sql+=" and price >? ";
            param.add(minprice);
        }
        if (maxprice!=null&&maxprice.trim().length()>0){
            sql+=" and price <? ";
            param.add(maxprice);
        }
        return template.query(sql, new BeanPropertyRowMapper<Products>(Products.class),param.toArray());
    }

    @Override
    public List<Products> getWeekHotProduct() {
        return null;
    }

    @Override
    public void changeProductNum(Order order) {


    }

    @Override
    public void updateProductNum(List<OrderItem> items) {
        String sql="update products set pnum=pnum-? where id=?";
        for (OrderItem item:items){
            template.update(sql,item.getBuynum(),item.getP().getId());
        }
    }

    @Override
    public List<Products> findBookByName(String searchfield) {
        return null;
    }
}
