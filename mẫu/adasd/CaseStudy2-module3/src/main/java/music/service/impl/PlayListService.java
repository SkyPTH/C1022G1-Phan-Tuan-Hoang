package music.service.impl;

import music.model.PlayList;
import music.model.Singer;
import music.model.TypeSong;
import music.repository.IPlayListRepository;
import music.repository.impl.PlayListRepository;
import music.service.IPlayListService;

import java.util.List;

public class PlayListService implements IPlayListService {
    IPlayListRepository iPlayListRepository = new PlayListRepository();
    @Override
    public List<PlayList> findAllPlayList(String search) {
        return iPlayListRepository.findAllPlayList(search);
    }

    @Override
    public void insertPlaylist(String nameSong, int singerId, int typeId) {
        iPlayListRepository.insertPlaylist(nameSong, singerId, typeId);
    }

    @Override
    public boolean deletePlayList(int id) {
        return iPlayListRepository.deletePlayList(id);
    }

    @Override
    public boolean update(PlayList playList) {
        return iPlayListRepository.update(playList);
    }

    @Override
    public PlayList findPlaylistById(int id) {
        return iPlayListRepository.findPlaylistById(id);
    }

    @Override
    public List<Singer> showSingerList() {
        return iPlayListRepository.showSingerList();
    }

    @Override
    public List<TypeSong> showTypeSongList() {
        return iPlayListRepository.showTypeSongList();
    }

}
