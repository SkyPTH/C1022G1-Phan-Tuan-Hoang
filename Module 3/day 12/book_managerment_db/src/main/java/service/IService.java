package service;

import model.Author;
import model.Book;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IService {
    List<Book>  displayList(String nameSearch) throws SQLException;
    void create(Book book) throws SQLException;
    void update(int id,Book book);
    void delete(int id);
    List<Author> authorList() throws SQLException;
    List<Category> categoryList() throws SQLException;
}
