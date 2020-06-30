package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.SingerRepository;
import xyz.yuanzhi.paganiniserver.domain.Singer;

import java.util.List;

@Service
public class SingerServiceImpl {

    @Autowired
    private SingerRepository repository;

    public Singer getSingerById(Integer singerId){
        return repository.findFirstBySingerId(singerId);
    }

    public List<Singer> getAllSingers(){
        return repository.findAll();
    }

    public Singer save(Singer singer){
        return repository.save(singer);
    }

    public void deleteAllBySingerId(Integer singerId){
        repository.deleteAllBySingerId(singerId);
    }

}
