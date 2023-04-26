package com.example.thi.repository;

import com.example.thi.model.PCT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPCTRepository extends PagingAndSortingRepository<PCT,Integer> {
    Page<PCT> findPCTByLeaderContaining(Pageable pageable,String search);
}
