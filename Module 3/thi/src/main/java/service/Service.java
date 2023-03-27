package service;

import model.Book;
import model.Category;
import repository.IRepository;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class Service implements IService {
    IRepository repository = new Repository();

    @Override
    public List<Book> displayList() throws SQLException {
        return repository.displayList();
    }

    @Override
    public void create(Book book) throws SQLException {
        repository.create(book);
    }

    @Override
    public void update(int id, Book book) {
        repository.update(id, book);
    }

    @Override
    public void delete(int id) throws SQLException {
        repository.delete(id);
    }

    @Override
    public List<Category> categoryList() throws SQLException {
        return repository.categoryList();
    }
}
