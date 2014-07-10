package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import service.interfaces.BookService;
import entity.Book;

public class BookManagementAction {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private Book book;

    public Book getBook() {
        return book;
    }

    public String execute() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String operation = req.getParameter("operation");
        if (operation.equals("edit")) {
            int id = Integer.valueOf(req.getParameter("id"));
            this.book = bookService.queryById(id);
            return "edit";
        } else if (operation.equals("save")) {
            int id = Integer.valueOf(req.getParameter("id"));
            Book book = bookService.queryById(id);
            book.setName(req.getParameter("name"));
            book.setAuthor(req.getParameter("author"));
            book.setPublisher(req.getParameter("publisher"));
            try {
                bookService.edit(book);
            } catch (HibernateOptimisticLockingFailureException e) {
                req.setAttribute("bookEditMessage", "乐观锁,有其他管理员正在修改");
                return "save";
            }
            req.setAttribute("bookEditMessage", "书籍修改成功");
            return "save";
        } else if (operation.equals("delete")) {
            int id = Integer.valueOf(req.getParameter("id"));
            bookService.delete(id);
            return "delete";
        } else if (operation.equals("new")) {
            String name = req.getParameter("name");
            String author = req.getParameter("author");
            String publisher = req.getParameter("publisher");
            Book book = new Book(name, author, publisher);
            bookService.add(book);
            req.setAttribute("bookNewMessage", "书籍添加成功");
            return "add";
        }
        return "error";
    }

}
