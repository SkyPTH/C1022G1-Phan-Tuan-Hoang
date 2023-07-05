package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.SkinDetail;
import com.example.riotshop_api.repository.ISkinDetailRepository;
import com.example.riotshop_api.service.ISkinDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinDetailService implements ISkinDetailService {
    @Autowired private ISkinDetailRepository iSkinDetailRepository;
    @Override
    public List<SkinDetail> skinDetail(int idProduct) {
        return iSkinDetailRepository.skinDetail(idProduct);
    }
}
