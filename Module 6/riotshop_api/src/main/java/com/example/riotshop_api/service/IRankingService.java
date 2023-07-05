package com.example.riotshop_api.service;

import com.example.riotshop_api.model.Ranking;

import java.util.List;

public interface IRankingService {
    List<Ranking> findAll();
}
