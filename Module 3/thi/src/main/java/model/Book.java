package model;

public class Book {
    private int bookID;
    private String bookName;
    private int pageSize;
    private Category category;

    public Book(int bookID, String bookName, int pageSize, Category category) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.pageSize = pageSize;
        this.category = category;
    }

    public Book(String bookName, int pageSize, Category category) {
        this.bookName = bookName;
        this.pageSize = pageSize;
        this.category = category;
    }

    public Book() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
