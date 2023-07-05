package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface IRankingRepository extends JpaRepository<Ranking,Integer> {
}
