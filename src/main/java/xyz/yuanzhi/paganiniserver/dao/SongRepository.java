package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.Song;

import javax.transaction.Transactional;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {

    Boolean existsBySongId(Integer songId);

    Song findFirstBySongId(Integer songId);

    List<Song> findAllByNameLike(String name);

    @Transactional
    void deleteAllBySongId(Integer songId);

    List<Song> findAllBySingerId(Integer singerId);
}
