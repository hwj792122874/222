package cn.edu.lsu.servlet.admin;

import cn.edu.lsu.bean.*;
import cn.edu.lsu.dao.*;
import cn.edu.lsu.dao.impl.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet({"/adminServlet","/showProducts","/addProduct","/editProduct","/deleteProduct","/findProductByManyCondition","/ListNoticeServlet","/AddNoticeServlet","/EditNoticeServlet","/FindByIdNoticeServlet","/DeleteNoticeServlet","/findOrders","/findOrderById","/findOrderByManyCondition","/delOrderById"})
@MultipartConfig(location="D:\\",fileSizeThreshold = 1024)
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        HttpSession session = request.getSession();
        UserDAO userDAO= new UserDaoImpl();
        ProductsDAO productsDAO=new ProductsDAOImpl();
        NoticeDAO noticeDAO=new NoticeDaoImpl();
        OrderDAO orderDAO=new OrderDAOImpl();
        OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
        request.setCharacterEncoding("UTF-8");
        String url = request.getRequestURI();
        if(url.endsWith("adminServlet")){
        String logonName = request.getParameter("logonName");
        String logonPwd = request.getParameter("logonPwd");
        User login = userDAO.login(logonName, logonPwd);
        //System.out.println(request.getContextPath());
        if (login!=null){
            session.setAttribute("user",login);
            request.getRequestDispatcher("admin/login/home.jsp").forward(request,response);
        }else{
            request.setAttribute("message","用户密码错误");
            request.getRequestDispatcher("admin/login/login.jsp").forward(request,response);
        }
        }else if(url.endsWith("showProducts")){
            List<Products> products = productsDAO.queryAll();
            context.setAttribute("products",products);
            request.getRequestDispatcher("admin/products/list.jsp").forward(request,response);

        }else if(url.endsWith("addProduct")){
            Part part = request.getPart("upload");
            String disposition = part.getHeader("Content-Disposition");
            String suffix = disposition.substring(disposition.lastIndexOf("."),disposition.length()-1);
            //随机的生存一个32的字符串
            String filename = UUID.randomUUID()+suffix;
            //获取上传的文件名
            InputStream is = part.getInputStream();
            //动态获取服务器的路径
            String serverpath = request.getServletContext().getRealPath("/productImg");

            FileOutputStream fos = new FileOutputStream(serverpath+"/"+filename);
            byte[] bty = new byte[1024];
            int length =0;
            while((length=is.read(bty))!=-1){
                fos.write(bty,0,length);
            }
            fos.close();
            is.close();
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String pnum = request.getParameter("pnum");
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            Products products=new Products();
            products.setName(name);
            products.setPrice(Double.parseDouble(price));
            products.setPnum(Integer.parseInt(pnum));
            products.setCategory(category);
            products.setDescription(description);
            products.setImgurl("productImg\\"+filename);
            productsDAO.addProducts(products);
            request.getRequestDispatcher("/showProducts").forward(request,response);
        }else if (url.endsWith("editProduct")){
            Products products=new Products();
            Part part = request.getPart("upload");
            if(part.getSubmittedFileName()!=null&&part.getSubmittedFileName().length()!=0) {
                String disposition = part.getHeader("Content-Disposition");
                String suffix = disposition.substring(disposition.lastIndexOf("."), disposition.length() - 1);
                //随机的生存一个32的字符串
                String filename = UUID.randomUUID() + suffix;
                //获取上传的文件名
                InputStream is = part.getInputStream();
                //动态获取服务器的路径
                String serverpath = request.getServletContext().getRealPath("/productImg");

                FileOutputStream fos = new FileOutputStream(serverpath + "/" + filename);
                byte[] bty = new byte[1024];
                int length = 0;
                while ((length = is.read(bty)) != -1) {
                    fos.write(bty, 0, length);
                }
                products.setImgurl("productImg\\"+filename);
                fos.close();
                is.close();
            }
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String pnum = request.getParameter("pnum");
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            String id=request.getParameter("id1");
            System.out.println(id);
            products.setId(id);
            products.setName(name);
            products.setPrice(Double.parseDouble(price));
            products.setPnum(Integer.parseInt(pnum));
            products.setCategory(category);
            products.setDescription(description);
            productsDAO.editProduct(products);
            request.getRequestDispatcher("/showProducts").forward(request,response);
        }else if (url.endsWith("deleteProduct")){
            String id = request.getParameter("id");
            productsDAO.delProducts(id);
            List<Products> products = productsDAO.queryAll();
            context.setAttribute("products",products);
            request.getRequestDispatcher("admin/products/list.jsp").forward(request,response);
        }else if(url.endsWith("findProductByManyCondition")){
            String id=request.getParameter("id");
            String category = request.getParameter("category");
            String name = request.getParameter("name");
            String minprice=request.getParameter("minprice");
            String maxprice = request.getParameter("maxprice");
            List<Products> products = productsDAO.findProductByManyCondition(id, category, name, minprice, maxprice);
            context.setAttribute("products",products);
            request.getRequestDispatcher("admin/products/list.jsp").forward(request,response);
        }else if (url.endsWith("ListNoticeServlet")){
            List<Notice> notices = noticeDAO.getAllNotices();
            context.setAttribute("notices",notices);
            context.setAttribute("n",null);
            request.getRequestDispatcher("admin/notices/list.jsp").forward(request,response);
        }else if(url.endsWith("AddNoticeServlet")){
            String title = request.getParameter("title");
            String details = request.getParameter("details");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            Notice notice=new Notice();
            notice.setN_time(dateString);
            notice.setTitle(title);
            notice.setDetails(details);
            noticeDAO.addNotice(notice);
            request.getRequestDispatcher("/ListNoticeServlet").forward(request,response);
        }else if (url.endsWith("EditNoticeServlet")){
            String title = request.getParameter("title");
            String details = request.getParameter("details");
            String id =request.getParameter("id1");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            Notice notice=new Notice();
            notice.setN_id(Integer.parseInt(id));
            notice.setN_time(dateString);
            notice.setTitle(title);
            notice.setDetails(details);
            noticeDAO.updateNotice(notice);
            request.getRequestDispatcher("/ListNoticeServlet").forward(request,response);
        }else if (url.endsWith("FindByIdNoticeServlet")){
            String id=request.getParameter("id");
            Notice n = noticeDAO.findNoticeById(id);
            context.setAttribute("n",n);
            request.getRequestDispatcher("admin/notices/edit.jsp").forward(request,response);
        }else if (url.endsWith("DeleteNoticeServlet")){
            String id=request.getParameter("id");
            noticeDAO.deleteNotice(id);
            List<Notice> notices = noticeDAO.getAllNotices();
            context.setAttribute("notices",notices);
            request.getRequestDispatcher("admin/notices/list.jsp").forward(request,response);
        }else if (url.endsWith("findOrders")){
            List<Order> allOrder = orderDAO.findAllOrder();
            context.setAttribute("orders",allOrder);
            request.getRequestDispatcher("admin/orders/list.jsp").forward(request,response);
        }else if (url.endsWith("findOrderById")){
            String id=request.getParameter("id");
            Order order=orderDAO.findOrderById(id);
            List<OrderItem> orderItemByOrder = orderItemDAO.findOrderItemByOrder(order);
            order.setOrderItems(orderItemByOrder);
            context.setAttribute("order",order);
            request.getRequestDispatcher("admin/orders/view.jsp").forward(request,response);
        }else if (url.endsWith("findOrderByManyCondition")){
            String id=request.getParameter("id");
            String receiverName=request.getParameter("receiverName");
            List<Order> orders = orderDAO.findOrderByManyCondition(id, receiverName);
            context.setAttribute("orders",orders);
            request.getRequestDispatcher("admin/orders/list.jsp").forward(request,response);
        }else if (url.endsWith("delOrderById")){
            String id=request.getParameter("id");
            Order order=new Order();
            order.setId(id);
            List<OrderItem> orderItemByOrder = orderItemDAO.findOrderItemByOrder(order);
            productsDAO.updateProductNum(orderItemByOrder);
            orderDAO.delOrderById(id);
            orderItemDAO.delOrderItems(id);
            List<Order> allOrder = orderDAO.findAllOrder();
            context.setAttribute("orders",allOrder);
            request.getRequestDispatcher("admin/orders/list.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
