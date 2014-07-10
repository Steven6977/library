package service.interfaces;

import java.util.List;

import entity.MyOrder;
import entity.Order;

public interface OrderService {
    public List<Order> queryOrders();

    public void returnBook(Order order);

    public Order queryById(int id);

    public void delete(int id);

    public void add(String useraccount, String[] bookIDs) throws Exception;

    public boolean existAccount(String useraccount);

    public boolean existBook(String bookname);

    public boolean existNotReturn(int userid);

    public boolean existBookByBookId(int bookid);

    public void deleteAll();

    public List<MyOrder> queryByUserId(int id);
}
