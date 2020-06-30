package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.SongListRepository;
import xyz.yuanzhi.paganiniserver.domain.Song;
import xyz.yuanzhi.paganiniserver.domain.SongList;

import java.util.List;

@Service
public class SongListServiceImpl {

    @Autowired
    private SongListRepository repository;

    public void addSongToCollect(SongList songList){
        repository.save(songList);
    }

    public void deleteSongFromCollect(Integer collectId, Integer songId){
        repository.deleteAllByCollectIdAndSongId(collectId, songId);
    }

    public List<Song> getSongsByCollectId(Integer collectId){
        //return repository.getSongsByCollectId(collectId);
        return null;
    }
}
