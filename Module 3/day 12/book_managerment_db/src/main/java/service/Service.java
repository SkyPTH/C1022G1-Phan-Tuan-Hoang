package service;

import model.Author;
import model.Book;
import model.Category;
import repository.IRepository;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class Service implements IService {
    IRepository iRepository = new Repository();

    @Override
    public List<Book> displayList(String nameSearch) throws SQLException {
        return iRepository.displayList(nameSearch);
    }

    @Override
    public void create(Book book) throws SQLException {
        iRepository.create(book);
    }

    @Override
    public void update(int id, Book book) throws SQLException {
        iRepository.update(id, book);
    }

    @Override
    public void delete(int id) {
        iRepository.delete(id);
    }

    @Override
    public List<Author> authorList() throws SQLException {
        return iRepository.authorList();
    }

    @Override
    public List<Category> categoryList() throws SQLException {
        return iRepository.categoryList();
    }

    @Override
    public Book findbyID(int id) throws SQLException {
        return iRepository.findbyID(id);
    }
}
