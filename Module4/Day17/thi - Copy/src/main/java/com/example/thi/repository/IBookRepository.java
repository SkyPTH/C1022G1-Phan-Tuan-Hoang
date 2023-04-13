package com.example.thi.repository;

import com.example.thi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book,Integer> {
    Page<Book>findBookByNameContaining(Pageable pageable,String search);
}
