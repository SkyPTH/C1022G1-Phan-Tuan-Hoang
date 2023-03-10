package service;

import model.Book;

import java.util.List;

public interface IBookService {
    List<Book> displayAll(String tittleSearch);
    void add(Book book);
    void update(int id,Book book);
    void delete(int id);

}
