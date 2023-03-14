package repository;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    public static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "qwe", 22, "rty", "uio"));
        bookList.add(new Book(2, "asd", 33, "fgh", "jkl"));
        bookList.add(new Book(3, "zxc", 44, "cvb", "bnm"));
    }

    @Override
    public List<Book> displayAll(String tittleSearch) {
        List<Book>bookList2=new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getTittle().contains(tittleSearch)){
                bookList2.add(bookList.get(i));
            }
        } return bookList2;
    }

    @Override
    public void add(Book book) {
        book.setId(bookList.get(bookList.size()-1).getId()+1);
        bookList.add(book);
    }

    @Override
    public void update(int id, Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getId()==id){
                bookList.set(i, book);
                break;
            }
        }
        ;
    }


    @Override
    public void delete(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if(id==bookList.get(i).getId()){
                id=i;
                break;
            }
        }
        bookList.remove(id);
    }

}
