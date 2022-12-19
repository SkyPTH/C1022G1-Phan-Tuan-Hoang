package BaiTap.Day12.Product.Model.service;

import BaiTap.Day12.Product.Model.model.Product;

public interface IProductService {
    void addProduct(Product product);

    void displayProduct();

    void updateProduct(int id, Product product);

    void removeProduct(int id);

    void searchProduct(String name);

    void sortAscending();

    void sortDescending();
    void containSearch(String charSequence);

}
