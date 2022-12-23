package BaiTap.quan_li_sp.Model.repository;

import BaiTap.quan_li_sp.Model.model.Product;

public interface IRepository {
    void addProduct(Product product);

    void displayProduct();

    void findProduct(String keyword);
}
