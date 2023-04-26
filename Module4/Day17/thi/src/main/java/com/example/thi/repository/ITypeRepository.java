package com.example.thi.repository;

import com.example.thi.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends PagingAndSortingRepository<Type,Integer> {
}
