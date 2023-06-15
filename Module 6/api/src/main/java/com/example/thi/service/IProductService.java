package com.example.thi.service;

import com.example.thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> list( String search);
    void save(Product product);

}
