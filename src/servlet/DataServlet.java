package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.interfaces.BookService;
import service.interfaces.OrderService;
import service.interfaces.UserService;
import entity.Book;
import entity.MyOrder;
import entity.Order;
import entity.User;

public class DataServlet extends HttpServlet {

    /**
     * 
     */
    private final String      BOOK             = "book";
    private final String      USER             = "user";
    private final String      ORDER            = "order";
    private final String      READER           = "reader";
    private final String      AVA_BOOK         = "ava_book";
    private final String      MYORDER          = "myorder";

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String type = req.getParameter("type");
        resp.setContentType("text/html;charset=UTF-8");
        if (type.equals(BOOK))
            queryBooks(req, resp);
        else if (type.equals(USER))
            queryUsers(req, resp);
        else if (type.equals(READER))
            queryReaders(req, resp);
        else if (type.equals(ORDER))
            queryOrders(req, resp);
        else if (type.equals(AVA_BOOK))
            queryAvaBook(req, resp);
        else if (type.equals(MYORDER))
            queryMyOrder(req, resp);
    }

    private void queryMyOrder(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext applicationContext = WebApplicationContextUtils
            .getWebApplicationContext(this.getServletContext());
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<MyOrder> myorders = orderService.queryByUserId(user.getId());
        print(req, resp, myorders);
    }

    private void queryAvaBook(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext applicationContext = WebApplicationContextUtils
            .getWebApplicationContext(this.getServletContext());
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        List<Book> avaBooks = bookService.queryAvaBook();
        print(req, resp, avaBooks);
    }

    private void queryUsers(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext applicationContext = WebApplicationContextUtils
            .getWebApplicationContext(this.getServletContext());
        UserService userService = (UserService) applicationContext.getBean("userService");
        List<User> users = userService.queryUsers();
        print(req, resp, users);
    }

    private void queryReaders(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void queryOrders(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext applicationContext = WebApplicationContextUtils
            .getWebApplicationContext(this.getServletContext());
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        UserService userSerivce = (UserService) applicationContext.getBean("userService");
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        
        List<Order> orders = orderService.queryOrders();
        
        JSONArray jsonDataArray = new JSONArray();
        jsonDataArray = JSONArray.fromObject(orders);
        for (int i=0;i<orders.size();++i) {
            Book book = bookService.queryById(orders.get(i).getBookid());
            User user = userSerivce.queryById(orders.get(i).getUserid());
            jsonDataArray.getJSONObject(i).put("username", user.getName());
            jsonDataArray.getJSONObject(i).put("bookname", book.getName());
        }
        print(req, resp, jsonDataArray);
    }

    private void queryBooks(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext applicationContext = WebApplicationContextUtils
            .getWebApplicationContext(this.getServletContext());
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        List<Book> books = bookService.queryAllBook();
        JSONArray jsonDataArray = new JSONArray();
        jsonDataArray = JSONArray.fromObject(books);
        JSONObject returnjobj = new JSONObject();
        returnjobj.put("aaData", jsonDataArray);
        try {
            resp.getWriter().print(returnjobj);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void print(HttpServletRequest req, HttpServletResponse resp, Object obj) {
        JSONArray jsonDataArray = new JSONArray();
        if (obj != null)
            jsonDataArray = JSONArray.fromObject(obj);
        JSONObject returnjobj = new JSONObject();
        returnjobj.put("aaData", jsonDataArray);
        if (obj == null)
            returnjobj.put("total", 0);
        try {
            resp.getWriter().print(returnjobj);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
