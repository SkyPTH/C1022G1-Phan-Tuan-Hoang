package BaiTap.quan_li_sp.service;

import BaiTap.quan_li_sp.Model.model.Product;

public interface IService {
    void addProduct(Product product);
    void displayProduct();
    void findProduct(String keyword);
}
