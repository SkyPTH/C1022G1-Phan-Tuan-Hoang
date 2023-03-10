package model;

public class Book {
    private int id;
    private String tittle;
    private int pageSize;
    private String author;
    private String category;

    public Book(int id, String tittle, int pageSize, String author, String category) {
        this.id = id;
        this.tittle = tittle;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public Book(String tittle, int pageSize, String author, String category) {
        this.tittle = tittle;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
