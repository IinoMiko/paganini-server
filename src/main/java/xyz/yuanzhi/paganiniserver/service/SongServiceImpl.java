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

    public Boolean existsBySongId(Integer songId){
        return repository.existsBySongId(songId);
    }

    public Song getSongById(Integer songId){
        return repository.findFirstBySongId(songId);
    }

    public List<Song> searchSongsByString(String name){
        return repository.findAllByNameLike(name);
    }

    public Song addOrModifySong(Song song){
        return repository.save(song);
    }

    public void deleteAllBySongId(Integer songId){
        repository.deleteAllBySongId(songId);
    }

    public long countAll(){
        return repository.count();
    }

    public List<Song> findAllBySingerId(Integer singerId){
        return repository.findAllBySingerId(singerId);
    }

}
