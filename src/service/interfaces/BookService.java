package service.interfaces;

import java.util.List;

import entity.Book;

public interface BookService {
    public List<Book> queryAllBook();

    public Book queryById(int id);

    public void edit(Book book);

    public void delete(int id);

    public void add(Book book);

    public List<Book> queryAvaBook();
  
}
