package service;

import model.Product;

import java.util.List;

public interface IService {
    List<Product> displayList();
    void create(Product product);
    void update(Product product);

    void delete(Product product);



    Product findbyID(int id);
}
