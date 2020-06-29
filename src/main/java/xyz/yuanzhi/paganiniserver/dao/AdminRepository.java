package xyz.yuanzhi.paganiniserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yuanzhi.paganiniserver.domain.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findAllByNameAndPassword(String name, String password);

}
