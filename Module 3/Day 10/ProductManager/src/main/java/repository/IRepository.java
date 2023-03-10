package repository;

import model.Product;

import java.util.List;

public interface IRepository {
    List<Product> displayList();
    Product findByID(int id);
    void update (Product product);
    void create (Product product);
    void delete(Product product);

}
