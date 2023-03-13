package repository;

import model.Author;
import model.Book;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    public static final String FINDBYNAME = "SELECT book.book_id, book.name, book.page_size,c.category_name, a.author_name from book " +
            "join category c on c.category_id = book.category_id " +
            "join author a on a.author_id = book.author_id where name like CONCAT('%',?,'%')";
    public static final String CREATE = "INSERT INTO book(name,page_size,author_id,category_id) values (?,?,?,?) ";
    public static final String FINDBYID = "select book.name,book.page_size,a.author_id,a.author_name,c.category_id,c.category_name from book join author a on a.author_id=book.author_id " +
            "join category c on c.category_id=book.category_id where book.book_id=?";
    public static final String UPDATE = "update book set name=?,page_size=?,author_id=?,category_id=? where book_id=?";
    public static final String DELETE = "delete from book where book_id=?";

    @Override
    public List<Book> displayList(String nameSearch) throws SQLException {
        List<Book> bookList = new ArrayList<>();
        if (nameSearch == null) {
            nameSearch = "";
        }
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);
        preparedStatement.setString(1, nameSearch);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int bookId = resultSet.getInt("book_id");
            String name = resultSet.getString("name");
            int pageSize = resultSet.getInt("page_size");
            String categoryName = resultSet.getString("category_name");
            String authorName = resultSet.getString("author_name");
            Author author = new Author(authorName);
            Category category = new Category(categoryName);
            Book book = new Book(bookId, name, pageSize, author, category);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public void create(Book book) throws SQLException {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setInt(2, book.getPageSize());
        preparedStatement.setInt(3, book.getAuthor().getAuthorID());
        preparedStatement.setInt(4, book.getCategory().getCategoryID());
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(int id, Book book)  {

        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setInt(2, book.getPageSize());
            preparedStatement.setInt(3, book.getAuthor().getAuthorID());
            preparedStatement.setInt(4, book.getCategory().getCategoryID());
            preparedStatement.setInt(5, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Author> authorList() throws SQLException {
        List<Author> authorList = new ArrayList<>();
        PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from author");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int authorID = resultSet.getInt(1);
            String authorName = resultSet.getString(2);
            Author author = new Author(authorID, authorName);
            authorList.add(author);
        }
        return authorList;
    }

    @Override
    public List<Category> categoryList() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from category");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int categoryID = resultSet.getInt(1);
            String categoryName = resultSet.getString(2);
            Category category = new Category(categoryID, categoryName);
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public Book findbyID(int id) throws SQLException {
        PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(FINDBYID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int pageSize = resultSet.getInt(2);
            int authorID = resultSet.getInt(3);
            String authorName = resultSet.getString(4);
            int categoryID = resultSet.getInt(5);
            String categoryName = resultSet.getString(6);
            Author author = new Author(authorID, authorName);
            Category category = new Category(categoryID, categoryName);
            Book book = new Book(name, pageSize, author, category);
            return book;
        }
        return null;
    }
}
