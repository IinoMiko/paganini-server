package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.yuanzhi.paganiniserver.domain.Collect;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectRepository extends JpaRepository<Collect, Integer> {

    List<Collect> findAllByUserIdAndType(Integer userId, Integer type);

    Long countByCollectId(Integer collectId);

    @Transactional
    void deleteByCollectId(Integer collectId);

    @Query("from Collect collect where collect.type=0")
    List<Collect> getAllSystemList();
}
