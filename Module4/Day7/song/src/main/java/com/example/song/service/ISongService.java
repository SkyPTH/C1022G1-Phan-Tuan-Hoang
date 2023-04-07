package com.example.song.service;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;

import java.util.List;

public interface ISongService {
    void save(SongDTO songDTO);

    Song findByID(int id);

    List<Song> list();
}
