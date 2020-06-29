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
        List<Singer> singers = repository.findAllBySingerId(singerId);
        return singers.isEmpty() ? null : singers.get(0);
    }

}
