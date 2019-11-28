package cn.hwj.domain;

import cn.hwj.dao.Daoimp;
import cn.hwj.dao.UserDao;

public class Test {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("1");
        user.setPassword("asd");
        UserDao dao=new UserDao();
        System.out.println(dao.login(user));

    }

}
