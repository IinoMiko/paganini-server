package xyz.yuanzhi.paganiniserver.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongListRepositoryTest {

    @Autowired
    private SongListRepository repository;

    @Test
    public void Test(){
        //System.out.println(repository.getSongsByCollectId(2));
    }

}