package BaiTap.Day12.Product.Model.repositoty;

import BaiTap.Day12.Product.Model.model.Product;

public interface IProductRepository {
    void addProduct(Product product);

    void displayProduct();

    void updateProduct(int id, Product product);

    void removeProduct(int id);

    void searchProduct(String name);

    void sortAscending();

    void sortDescending();
}
