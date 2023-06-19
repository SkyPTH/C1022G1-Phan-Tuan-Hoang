package com.example.riotshop_api.model;

import javax.persistence.*;

@Entity
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRanking;
    @Column(name = "name_ranking")
    private String nameRanking;

    public Ranking(int idRanking, String nameRanking) {
        this.idRanking = idRanking;
        this.nameRanking = nameRanking;
    }

    public Ranking() {
    }

    public int getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }

    public String getNameRanking() {
        return nameRanking;
    }

    public void setNameRanking(String nameRanking) {
        this.nameRanking = nameRanking;
    }
}
