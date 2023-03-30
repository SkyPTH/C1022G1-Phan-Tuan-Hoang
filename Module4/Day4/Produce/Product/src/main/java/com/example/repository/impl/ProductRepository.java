package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Xe đạp", 1000, "Made in VN", "Việt Nam"));
    }

    @Override
    public List<Product> list() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(new Product(productList.size(), product.getName(), product.getPrice(), product.getDescription(), product.getProducer()));
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product findbyID(int id) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId()==id){
                return productList.get(i);
            }
        }
        return null;
    }
}
