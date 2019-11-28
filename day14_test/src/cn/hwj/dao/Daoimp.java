package cn.hwj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Daoimp {
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet resultSet;
    public Daoimp() {
        init();
    }
    /**
     * 初始化数据的 方法
     */
    public void init() {
        connection = JDBCUtils.getConnection();
    }
    public boolean executeUpdate(String sql ,Object [] obj) {

        boolean execute = false;
        try {

            // sql=insert into card (id,name,class_name,money,password,num_of_bank_card) values (?,?,?,?,?,?)

            //通过用户传来的Sql语句直接 创建一个PreparedStatement对象
            pst = connection.prepareStatement(sql);


            for (int i = 0; i < obj.length ; i++) {
                pst.setObject(i+1, obj[i]);
            }

            int executeUpdate = pst.executeUpdate();
            if(executeUpdate > 0 ) {

                execute = true;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {

            closeAll();
        }


        return execute;
    }

    public ResultSet executeFind(String sql,Object[] params) {


        // sql = select * from card  where  money > ?;
        try {
            pst = connection.prepareStatement(sql);
            if(params!=null) {

                for (int i = 0; i < params.length; i++) {

                    pst.setObject(i+1, params[i]);

                }
            }

            resultSet = pst.executeQuery();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return resultSet;
    }

    /*
     * 关闭所有资源
     */
    private void closeAll() {

//        if(connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }

        if(pst!=null) {

            try {
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
