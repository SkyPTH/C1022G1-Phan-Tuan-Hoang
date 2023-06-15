package com.example.thi.service.impl;

import com.example.thi.model.Product;
import com.example.thi.repository.IProductRepository;
import com.example.thi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> list(String search) {
        return iProductRepository.findProductByNameContaining(search);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }
}
