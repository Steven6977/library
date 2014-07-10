package service;

import java.util.ArrayList;
import java.util.List;

import service.interfaces.BookService;
import dao.interfaces.BookDao;
import dao.interfaces.OrderDao;
import entity.Book;
import entity.Order;

public class BookServiceImpl implements BookService {

    private BookDao  bookDao;
    private OrderDao orderDao;

    public BookServiceImpl(){}
    
    public BookServiceImpl(BookDao bookDao, OrderDao orderDao) {
        this.bookDao = bookDao;
        this.orderDao = orderDao;
    }

    public List<Book> queryAllBook() {
        return bookDao.queryAllBook();
    }

    public Book queryById(int id) {
        return bookDao.queryById(id);
    }

    public void edit(Book book) {        
        bookDao.update(book);
    }

    public void delete(int id) {
        bookDao.delete(id);
    }

    public void add(Book book) {
        bookDao.save(book);
    }

    /**
     * 返回未借出的书籍
     * @see service.interfaces.BookService#queryAvaBook()
     */
    @Override
    public List<Book> queryAvaBook() {
        List<Book> books = bookDao.queryAllBook();
        List<Order> unReOrders = orderDao.queryAllUnReOrders();
        List<Book> avaBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            boolean flag = true;
            for (Order o : unReOrders) {
                if (books.get(i).getId() == o.getBookid()) {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
                avaBooks.add(books.get(i));
        }
        return avaBooks;
    }

    
    
}
