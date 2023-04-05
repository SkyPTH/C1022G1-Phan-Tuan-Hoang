package com.example.song.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Tên bài hát không được để trống")
    private String name;
    @Column(name = "singer")
    @NotBlank(message = "Tên ca sĩ không được để trống")
    private String singer;
    @Column(name = "type")
    @NotBlank(message = "Thể loại nhạc không được để trống")
    private String type;

    public Song(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Song(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
