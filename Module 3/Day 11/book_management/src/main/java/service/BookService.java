package service;

import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService {
    IBookRepository bookRepository = new BookRepository();

    @Override
    public List<Book> displayAll(String tittleSearch) {

        return bookRepository.displayAll(tittleSearch);
    }

    @Override
    public void add(Book book) {
        bookRepository.add(book);

    }

    @Override
    public void update(int id, Book book) {
        bookRepository.update(id, book);

    }

    @Override
    public void delete(int id) {
        bookRepository.delete(id);

    }


}
