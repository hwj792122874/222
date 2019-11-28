package cn.hwj.dao;

import cn.hwj.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User login(User LoginUser){
        Daoimp dao = new Daoimp();
        String sql="select * from secret WHERE username=? and password=?";
        String [] params = new String [] {LoginUser.getUsername(),LoginUser.getPassword()};
        ResultSet sets = dao.executeFind(sql, params);
        User user=null;
        try {
            while (sets.next()) {
                String username = sets.getString("username");
                String password = sets.getString("password");
                user=new User(username,password);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
}
