package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.Product;
import com.example.riotshop_api.repository.IProductRepository;
import com.example.riotshop_api.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> searchProduct(String name, String idRanking, String nameSkin, String minPrice, String maxPrice, Pageable pageable) {
        return iProductRepository.searchProduct(name, idRanking, nameSkin, minPrice, maxPrice, pageable);
    }
    @Override
    public Product findProductByIdProduct(int id) {
        return iProductRepository.findProductByIdProduct(id);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }
}
