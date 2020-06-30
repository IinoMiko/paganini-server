package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.yuanzhi.paganiniserver.domain.Song;
import xyz.yuanzhi.paganiniserver.domain.SongList;

import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.List;

public interface SongListRepository extends JpaRepository<SongList, Integer> {

    @Transactional
    void deleteAllByCollectIdAndSongId(Integer collectId, Integer songId);

//    @Query(nativeQuery = true, value = "SELECT * FROM song WHERE song_id " +
//            "IN (SELECT song_id FROM song_list WHERE collect_id = :collectId)")
//    List<Object> getSongsByCollectId(Integer collectId);
}
