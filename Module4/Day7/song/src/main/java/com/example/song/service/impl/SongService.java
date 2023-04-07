package com.example.song.service.impl;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.repository.ISongRepository;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public void save(SongDTO songDTO) {
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        iSongRepository.save(song);
    }

    @Override
    public Song findByID(int id) {
        return iSongRepository.findById(id).get();
    }

    @Override
    public List<Song> list() {
        return (List<Song>) iSongRepository.findAll();
    }
}
