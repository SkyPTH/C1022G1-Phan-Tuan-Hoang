package com.example.cart.service.impl;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepository;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.ofNullable(iProductRepository.findById(id));
    }

    @Override
    public Product findByIdProDuct(int id) {
        return iProductRepository.findById(id);
    }
}
