package com.example.riotshop_api.controller;

import com.example.riotshop_api.model.Ranking;
import com.example.riotshop_api.service.IRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/public/ranking")
public class RankingController {
    @Autowired
    private IRankingService iRankingService;
    @GetMapping("")
    public List<Ranking> findAll(){
        return iRankingService.findAll();
    }
}
