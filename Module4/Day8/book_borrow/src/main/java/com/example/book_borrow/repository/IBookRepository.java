package com.example.book_borrow.repository;

import com.example.book_borrow.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book,Integer> {
    Page<Book> findBookByBookNameContaining(Pageable pageable,String search);
}
