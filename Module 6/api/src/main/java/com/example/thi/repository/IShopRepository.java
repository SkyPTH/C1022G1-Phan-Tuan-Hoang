package com.example.thi.repository;

import com.example.thi.model.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IShopRepository extends PagingAndSortingRepository<Shop,Integer> {
}
