package BaiTap.Day12.Product.Model.service;

import BaiTap.Day12.Product.Model.model.Product;
import BaiTap.Day12.Product.Model.repositoty.IProductRepository;
import BaiTap.Day12.Product.Model.repositoty.ProductRepository;

public class ProductService implements IProductService {
    private IProductRepository repository = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    @Override
    public void displayProduct() {
        repository.displayProduct();
    }

    @Override
    public void updateProduct(int id, Product product) {
        repository.updateProduct(id, product);
    }

    @Override
    public void removeProduct(int id) {
        repository.removeProduct(id);
    }

    @Override
    public void searchProduct(String name) {
        repository.searchProduct(name);
    }

    @Override
    public void sortAscending() {
        repository.sortAscending();
    }

    @Override
    public void sortDescending() {
        repository.sortDescending();
    }
}
