package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.Ranking;
import com.example.riotshop_api.repository.IRankingRepository;
import com.example.riotshop_api.service.IRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService implements IRankingService {
    @Autowired
    private IRankingRepository iRankingRepository;
    @Override
    public List<Ranking> findAll() {
        return iRankingRepository.findAll();
    }
}
