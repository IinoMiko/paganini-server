package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByNameAndPassword(String name, String password);

    List<User> findAllByName(String name);

    List<User> findAllByUserId(Integer userId);

    @Transactional
    void deleteAllByUserId(Integer userId);

    Long countAllBySex(Boolean sex);
}
