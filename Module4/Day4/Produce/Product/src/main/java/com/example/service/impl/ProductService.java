package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.repository.impl.ProductRepository;
import com.example.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> list() {
        return iProductRepository.list();
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public Product findbyID(int id) {
        return iProductRepository.findbyID(id);
    }
}
