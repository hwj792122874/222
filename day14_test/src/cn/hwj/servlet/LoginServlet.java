package cn.hwj.servlet;



import cn.hwj.dao.UserDao;
import cn.hwj.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet1")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao dao=new UserDao();
        User user1 = dao.login(user);
        if(user1==null){
        request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            request.setAttribute("user",user1);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }
}
