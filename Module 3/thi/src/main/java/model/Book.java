package model;

public class Book {
    private int id;
    private String name;
    private int pageSize;
    private Category category;

    public Book(int id, String name, int pageSize, Category category) {
        this.id = id;
        this.name = name;
        this.pageSize = pageSize;
        this.category = category;
    }

    public Book(String name, int pageSize, Category category) {
        this.name = name;
        this.pageSize = pageSize;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
