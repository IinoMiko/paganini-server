package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.Singer;

import javax.transaction.Transactional;
import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Integer> {

    Singer findFirstBySingerId(Integer singerId);

    List<Singer> findAll();

    @Transactional
    void deleteAllBySingerId(Integer singerId);
}
