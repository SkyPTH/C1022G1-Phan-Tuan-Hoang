package BaiTap.quan_li_sp.Model.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String manufactured;
    private int price;
    private String description;

    public Product(int id, String name, String manufactured, int price, String description) {
        this.id = id;
        this.name = name;
        this.manufactured = manufactured;
        this.price = price;
        this.description = description;
    }

    public Product() {
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

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufactured='" + manufactured + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
