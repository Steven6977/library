package service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import service.interfaces.OrderService;
import util.Constants;
import util.Util;
import dao.interfaces.BookDao;
import dao.interfaces.OrderDao;
import dao.interfaces.UserDao;
import entity.Book;
import entity.MyOrder;
import entity.Order;
import entity.User;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private BookDao  bookDao;
    private UserDao  userDao;

    public OrderServiceImpl() {
    };

    public OrderServiceImpl(OrderDao orderDao, BookDao bookDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public List<Order> queryOrders() {
        return orderDao.queryOrders();
    }

    public void returnBook(Order order) {
        String s = Util.getDate();
        order.setReturndate(s);
        order.setIfreturn(1);
        orderDao.update(order);
        
        Book book = bookDao.queryById(order.getBookid());
        book.setState(Constants.int_available);
        bookDao.update(book);
        
    }

    public Order queryById(int id) {
        return orderDao.queryById(id);
    }

    public void delete(int id) {
        orderDao.delete(id);
    }

    /**
     * 事务管理添加借书记录
     * @see service.interfaces.OrderService#add(java.lang.String, java.lang.String[])
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(String useraccount, String[] bookIds) throws Exception {
        User user = userDao.queryByAccount(useraccount);
        String s = Util.getDate();
        for (String bookId : bookIds) {
            Order order = new Order();
            order.setBorrowdate(s);
            order.setIfreturn(0);
            order.setUserid(user.getId());
            order.setBookid(Integer.valueOf(bookId));
            orderDao.save(order);
            Book book = bookDao.queryById(Integer.valueOf(bookId));
            book.setState(Constants.int_inavailable);
            bookDao.update(book);
        }

    }

    public boolean existAccount(String useraccount) {
        return userDao.exist(useraccount);
    }

    public boolean existBook(String bookname) {
        Book book = bookDao.queryByName(bookname);
        if (book != null) {
            return !orderDao.existBook(book.getId());
        }
        return false;
    }

    /**
     * 现在只考虑存在借阅记录的情况
     */
    public boolean existNotReturn(int userid) {
        return this.queryByUserId(userid) == null ? false : true;
    }

    /**
     * 现在只考虑存在借阅记录的情况
     */
    public boolean existBookByBookId(int bookid) {
        List<Order> order = orderDao.queryByBookId(bookid);
        return order == null ? false : true;
    }

    public void deleteAll() {
        orderDao.deleteAll();
    }

    /**
     * 查询某user id的order记录
     * @see service.interfaces.BookService#queryByUserId(int)
     */
    @Override
    public List<MyOrder> queryByUserId(int id) {
        List<Order> orders = orderDao.queryByUserId(id);    
        List<MyOrder> myOrders = new ArrayList<MyOrder>();
        
        for (Order o : orders) {
            Book b = bookDao.queryById(o.getBookid());
            MyOrder m = new MyOrder(b,o);
            myOrders.add(m);
        }    
        
        return myOrders.size() > 0 ? myOrders : null;
    }
}
