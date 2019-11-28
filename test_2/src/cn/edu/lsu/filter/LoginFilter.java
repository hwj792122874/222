package cn.edu.lsu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config=filterConfig;
    }

    @Override
    public void destroy() {
        config=null;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();
        if (session.getAttribute("user")==null&&!servletPath.endsWith("/adminServlet")&&!servletPath.endsWith("/admin/login/login.jsp")&&!servletPath.endsWith("/admin/images")){
            request.setAttribute("message","你还没有登陆");
            request.getRequestDispatcher("/admin/login/login.jsp").forward(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
