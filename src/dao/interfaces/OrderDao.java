package dao.interfaces;

import java.util.List;

import entity.Order;

public interface OrderDao {
    public List<Order> queryOrders();

    public void update(Order order);

    public Order queryById(int id);

    public void delete(int id);

    public void save(Order order);

    public boolean existBook(int bookid);

    public List<Order> queryByUserId(int userid);

    public List<Order> queryByBookId(int bookid);

    public void deleteAll();

    public List<Order> queryAllUnReOrders();
}
