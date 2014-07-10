package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.interfaces.OrderService;
import service.interfaces.UserService;
import entity.User;

public class ValidateServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String operation = req.getParameter("operation");
        if (operation.equals("adduseraccount")) {
            String useraccount = req.getParameter("useraccount");
            ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
            UserService userService = (UserService) applicationContext.getBean("userService");
            boolean flag = !userService.exist(useraccount);
            ajaxValidaOutput("useraccount", flag, resp);
        } else if (operation.equals("orderbookname")) {
            String bookname = req.getParameter("bookname");
            ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
            OrderService orderService = (OrderService) applicationContext.getBean("orderService");
            boolean flag = orderService.existBook(bookname);
            ajaxValidaOutput("bookname", flag, resp);
        } else if (operation.equals("orderuseraccount")) {
            String useraccount = req.getParameter("useraccount");
            ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
            UserService userService = (UserService) applicationContext.getBean("userService");
            boolean flag = userService.exist(useraccount);
            ajaxValidaOutput("useraccount", flag, resp);
        } else if (operation.equals("checkDeleteUser")) {
            int id = Integer.valueOf(req.getParameter("id"));
            ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
            OrderService orderService = (OrderService) applicationContext.getBean("orderService");
            boolean flag = orderService.existNotReturn(id);
            try {
                resp.getWriter().print(flag);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (operation.equals("checkDeleteBook")) {
            int id = Integer.valueOf(req.getParameter("id"));
            ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
            OrderService orderService = (OrderService) applicationContext.getBean("orderService");
            boolean flag = orderService.existBookByBookId(id);
            try {
                resp.getWriter().print(flag);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (operation.equals("modifypassword")) {
            String oldpwd = req.getParameter("oldpassword");
            ApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(this.getServletContext());
            UserService userService = (UserService) applicationContext.getBean("userService");
            User user = (User) req.getSession().getAttribute("user");
            boolean flag = userService.validatePwd(oldpwd, user);
            ajaxValidaOutput("oldpassword", flag, resp);
        }
    }

    private void ajaxValidaOutput(String documentId, Boolean flag, HttpServletResponse resp) {
        JSONArray ajaxResult = new JSONArray();
        ajaxResult.add(documentId);
        ajaxResult.add(flag);
        try {
            resp.getWriter().print(ajaxResult);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
