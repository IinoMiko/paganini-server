package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.SongList;

import javax.transaction.Transactional;

public interface SongListRepository extends JpaRepository<SongList, Integer> {

    @Transactional
    void deleteAllByCollectIdAndSongId(Integer collectId, Integer songId);
}
