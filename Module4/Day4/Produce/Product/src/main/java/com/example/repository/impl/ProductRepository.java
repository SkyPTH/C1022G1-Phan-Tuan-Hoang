package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Xe đạp", 1000, "Made in VN", "Việt Nam"));
        productList.add(new Product(2, "Xe oto", 1000, "Made in VN", "Việt Nam"));
    }

    @Override
    public List<Product> list(String search) {
        if (search == null) {
            search = "";
        }
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(search)) {
                list.add(productList.get(i));
            }
        }
        return list;
    }

    @Override
    public void create(Product product) {
        int id = 1;
        if (productList.size() != 0) {
            id = productList.get(productList.size() - 1).getId() + 1;
        }
        productList.add(new Product(id, product.getName(), product.getPrice(), product.getDescription(), product.getProducer()));
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
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }
}
