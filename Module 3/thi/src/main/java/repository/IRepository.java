package repository;

import model.Book;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IRepository {
    List<Book> bookList() throws SQLException;
    List<Category> categoryList() throws SQLException;
    void create(Book book) throws SQLException;
    void update(int id,Book book);
    void delete(int id) throws SQLException;
}
