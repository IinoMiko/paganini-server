package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.Singer;

import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Integer> {

    List<Singer> findAllBySingerId(Integer singerId);
}
