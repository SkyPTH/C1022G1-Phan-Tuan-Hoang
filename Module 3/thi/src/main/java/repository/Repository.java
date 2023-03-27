package repository;

import model.Book;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{

    @Override
    public List<Book> displayList() throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT book_id,book_name,page_size,c.category_id,c.category_name from book join category c on book.category_id=c.category_id");
        List<Book> bookList=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            int id=resultSet.getInt(1);
            String bookName=resultSet.getString(2);
            int pageSize= resultSet.getInt(3);
            int categoryID=resultSet.getInt(4);
            String categoryName=resultSet.getString(5);
            Category category=new Category(categoryID,categoryName);
            Book book=new Book(id,bookName,pageSize,category);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public void create(Book book) throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO book(book_name,page_size,category_id) values (?,?,?)");
        preparedStatement.setString(1,book.getBookName());
        preparedStatement.setInt(2,book.getPageSize());
        preparedStatement.setInt(3,book.getCategory().getCategoryID());
       preparedStatement.executeUpdate();
    }

    @Override
    public void update(int id, Book book) {

    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("");
    }

    @Override
    public List<Category> categoryList() throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * from category;");
        List<Category> categoryList=new ArrayList<>();
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            int categoryID=resultSet.getInt(1);
            String categoryName= resultSet.getString(2);
            Category category=new Category(categoryID,categoryName);
            categoryList.add(category);
        }
        return categoryList;
    }
}
