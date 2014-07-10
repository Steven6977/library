package dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.BookDao;
import entity.Book;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

    public static String HQL_QUERY_ALL_BOOK = "from Book";
    public static String HQL_QUERY_BOOK     = "from Book where id = ?";
    public static String HQL_UPDATE_BOOK    = "update Book set name = ?, author = ? , publisher = ? where id = ?";
    public static String HQL_DELETE_BOOK    = "delete Book where id = ?";
    public static String HQL_QUERY_BY_NAME  = "from Book where name = ?";
    public static String HQL_EXIST          = "from Book where name = ?";

    public List<Book> queryAllBook() {
        return this.getSession().createQuery(HQL_QUERY_ALL_BOOK).list();
    }

    public Book queryById(int id) {
        List<Book> list = this.getHibernateTemplate().find(HQL_QUERY_BOOK, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void update(Book book) {
        this.getHibernateTemplate().update(book);
        //this.getHibernateTemplate().merge(book);
    }

    public void delete(int id) {
        this.getHibernateTemplate().bulkUpdate(HQL_DELETE_BOOK, id);
    }

    public void save(Book book) {
        this.getHibernateTemplate().save(book);
    }

    public Book queryByName(String name) {
        List<Book> list = this.getHibernateTemplate().find(HQL_QUERY_BY_NAME, name);
        return list.size() > 0 ? list.get(0) : null;
    }

    public boolean exist(String name) {
        List<Book> list = this.getHibernateTemplate().find(HQL_EXIST, name);
        return list.size() > 0 ? true : false;
    }

}
