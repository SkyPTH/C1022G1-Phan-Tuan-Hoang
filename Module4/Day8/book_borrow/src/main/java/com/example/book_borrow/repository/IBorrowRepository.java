package com.example.book_borrow.repository;

import com.example.book_borrow.model.Borrow;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends PagingAndSortingRepository<Borrow, Integer> {
    Borrow findBorrowByStudent_StudentIDAndBook_BookID(int studentID, int bookID);
}
