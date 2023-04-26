package com.example.thi.service.impl;

import com.example.thi.model.PCT;
import com.example.thi.repository.IPCTRepository;
import com.example.thi.service.IPCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PCTService implements IPCTService {
    @Autowired
    private IPCTRepository ipctRepository;
    @Override
    public Page<PCT> list(Pageable pageable,String search) {
        return ipctRepository.findPCTByLeaderContaining(pageable,search);
    }

    @Override
    public void save(PCT pct) {
        ipctRepository.save(pct);
    }

    @Override
    public void delete(int id) {
        ipctRepository.deleteById(id);
    }

    @Override
    public PCT findById(int id) {
        return ipctRepository.findById(id).get();
    }
}
