package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.RankRepository;
import xyz.yuanzhi.paganiniserver.domain.MyRank;

import java.util.List;

@Service
public class RankServiceImpl {

    @Autowired
    private RankRepository repository;

    public List<MyRank> getRanks(){
        return repository.findAll();
    }

}
