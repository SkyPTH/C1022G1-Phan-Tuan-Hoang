package com.example.book_borrow.service.impl;

import com.example.book_borrow.model.Borrow;
import com.example.book_borrow.repository.IBorrowRepository;
import com.example.book_borrow.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository iBorrowRepository;

    @Override
    public void save(Borrow borrow) {
        iBorrowRepository.save(borrow);
    }

    public List<Borrow> list() {
        return (List<Borrow>) iBorrowRepository.findAll();
    }

    @Override
    public Borrow findBorrow(int borrowCode) {
        return iBorrowRepository.findBorrowByBorrowCode(borrowCode);
    }
}
