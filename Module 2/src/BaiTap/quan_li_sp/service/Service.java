package BaiTap.quan_li_sp.service;


import BaiTap.quan_li_sp.Model.model.Product;
import BaiTap.quan_li_sp.Model.repository.Repository;

public class Service implements IService {
    Repository repository = new Repository();

    @Override
    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    @Override
    public void displayProduct() {
        repository.displayProduct();
    }

    @Override
    public void findProduct(String keyword) {
        repository.findProduct(keyword);
    }
}