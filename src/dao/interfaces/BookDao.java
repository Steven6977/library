package dao.interfaces;

import java.util.List;

import entity.Book;

public interface BookDao {
	public List<Book> queryAllBook();
	public Book queryById(int id);
	public void update(Book book);
	public void delete(int id);
	public void save(Book book);
	public Book queryByName(String name);
	public boolean exist(String name);
}
