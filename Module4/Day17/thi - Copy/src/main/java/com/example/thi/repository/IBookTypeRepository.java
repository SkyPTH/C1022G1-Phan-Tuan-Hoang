package com.example.thi.repository;

import com.example.thi.model.BookType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBookTypeRepository extends PagingAndSortingRepository<BookType,Integer> {
}
