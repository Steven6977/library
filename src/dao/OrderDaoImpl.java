package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.OrderDao;
import entity.Book;
import entity.MyOrder;
import entity.Order;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

    public static String HQL_QUERY_ALL_ORDER      = "from Order";
    public static String HQL_QUERY_ORDER          = "from Order where id = ?";
    public static String HQL_DELETE_ORDER         = "delete Order where id = ?";
    public static String HQL_EXIST_BOOK           = "from Order where bookid = ? and ifreturn = 0";
    public static String HQL_QUERY_BY_USERID      = "from Order where userid = ?";
    public static String HQL_QUERY_BY_BOOKID      = "from Order where bookid = ?";
    public static String HQL_DELETE_ALL           = "delete Order where ifreturn = 1";
    public static String HQL_QUERY_ALL_UNRE_ORDER = "from Order where ifreturn = 0";

    public List<Order> queryOrders() {
        return this.getHibernateTemplate().find(HQL_QUERY_ALL_ORDER);
    }

    public void update(Order order) {
        String hql = "update Order set userid = '" + order.getUserid() + "', bookid = '"
                     + order.getBookid() + "', borrowdate = '" + order.getBorrowdate()
                     + "', returndate = '" + order.getReturndate() + "', ifreturn = '"
                     + order.getIfreturn() + "' where id = ?";
        this.getHibernateTemplate().merge(order);
    }

    public Order queryById(int id) {
        List<Order> list = this.getHibernateTemplate().find(HQL_QUERY_ORDER, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void delete(int id) {
        this.getHibernateTemplate().bulkUpdate(HQL_DELETE_ORDER, id);
    }

    public void save(Order order) {
        this.getHibernateTemplate().save(order);
    }

    public boolean existBook(int bookid) {
        List<Order> list = this.getHibernateTemplate().find(HQL_EXIST_BOOK, bookid);
        return list.size() > 0 ? true : false;
    }

    public List<Order> queryByUserId(int userid) {
        List<Order> list = this.getHibernateTemplate().find(HQL_QUERY_BY_USERID, userid);        
        return list;
    }

    public List<Order> queryByBookId(int bookid) {
        List<Order> list = this.getHibernateTemplate().find(HQL_QUERY_BY_BOOKID, bookid);
        return list.size() > 0 ? list : null;
    }

    public void deleteAll() {
        this.getHibernateTemplate().bulkUpdate(HQL_DELETE_ALL);
    }

    @Override
    public List<Order> queryAllUnReOrders() {
        return this.getHibernateTemplate().find(HQL_QUERY_ALL_UNRE_ORDER);
    }

}
