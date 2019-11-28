package cn.edu.lsu.dao;

import cn.edu.lsu.bean.User;

public interface UserDAO {
	
	//登录
  public User login(String username, String password);
//注册用户
  public void register(User user);
}
