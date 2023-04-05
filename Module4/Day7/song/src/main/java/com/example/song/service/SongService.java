package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository iSongRepository;
    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }


}
