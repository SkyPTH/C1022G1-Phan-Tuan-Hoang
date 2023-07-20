package com.example.riotshop_api.service;

import com.example.riotshop_api.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService {
    Page<Product> searchProduct(String name, String idRanking, String nameSkin, String minPrice, String maxPrice, Pageable pageable);
    Product findProductByIdProduct(int id);
    Product save(Product product);
    public void delete(Integer id);
}
