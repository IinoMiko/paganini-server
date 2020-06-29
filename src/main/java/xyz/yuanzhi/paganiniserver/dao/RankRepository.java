package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.MyRank;

public interface RankRepository extends JpaRepository<MyRank, Integer> {
}
