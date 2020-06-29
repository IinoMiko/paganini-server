package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.SongRepository;
import xyz.yuanzhi.paganiniserver.domain.Song;

import java.util.List;

@Service
public class SongServiceImpl {

    @Autowired
    private SongRepository repository;

    public Long countBySongId(Integer songId){
        return repository.countBySongId(songId);
    }

    public Song getSongById(Integer songId){
        List<Song> songs = repository.findAllBySongId(songId);
        return songs.isEmpty() ? null : songs.get(0);
    }

    public List<Song> searchSongsByString(String name){
        return repository.findAllByNameLike(name);
    }

}
