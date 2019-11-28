package cn.edu.lsu.dao.impl;

import cn.edu.lsu.bean.User;
import cn.edu.lsu.dao.UserDAO;
import cn.edu.lsu.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDAO {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User login(String username, String password)  {
        try {
            String sql="select * from user where username=? and password=?";
            User  user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;

        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void register(User user) {

    }
}
