package com.example.thi.service;

import com.example.thi.model.PCT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPCTService {
    Page<PCT> list(Pageable pageable,String search);
    void save(PCT pct);
    void delete(int id);
    PCT findById(int id);
}
