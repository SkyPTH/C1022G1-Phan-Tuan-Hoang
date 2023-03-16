package repository;

import model.Book;
import model.Category;
import service.IService;
import service.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{

    @Override
    public List<Book> bookList() throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select book.book_id,book.book_name,book.page_size,c.category_id,c.category_name from book join category c on c.category_id=book.category_id;");
//        preparedStatement.executeUpdate();
        List<Book>bookList=new ArrayList<>();
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            int id= resultSet.getInt(1);
            String name= resultSet.getString(2);
            int pageSize= resultSet.getInt(3);
            int categoryID=resultSet.getInt(4);
            String categoryName= resultSet.getString(5);
            Category category=new Category(categoryID,categoryName);
            Book book=new Book(id,name,pageSize,category);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Category> categoryList() throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("select * from category");
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Category> categoryList=new ArrayList<>();
        while (resultSet.next()){
            int categoryID=resultSet.getInt(1);
            String categoryName= resultSet.getString(2);
            Category category=new Category(categoryID,categoryName);
           categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public void create(Book book) throws SQLException {
        Connection connection=BaseRepository.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("insert into book(book_name,page_Size,category_id) values (?,?,?)");
    preparedStatement.setString(1,book.getName());
    preparedStatement.setInt(2,book.getPageSize());
//    int categoryID=book.getCategory().getCategoryID();
//    String categoryName=book.getCategory().getCategoryName();
//    Category category=new Category(categoryID,categoryName);
    preparedStatement.setInt(3,book.getCategory().getCategoryID());
    preparedStatement.executeUpdate();




    }

    @Override
    public void update(int id, Book book) {

    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection=BaseRepository.getConnection();
        CallableStatement callableStatement = connection.prepareCall("call delete_books(?)");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
    }
}
