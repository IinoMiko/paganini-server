package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.UserRepository;
import xyz.yuanzhi.paganiniserver.domain.User;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository repository;

    public User getUser(String name, String password){
        List<User> users = repository.findAllByNameAndPassword(name, password);
        return users.isEmpty() ? null : users.get(0);
    }

    public Boolean searchUser(String name){
        List<User> users = repository.findAllByName(name);
        return !users.isEmpty();
    }

    public User getUser(Integer userId){
        List<User> users = repository.findAllByUserId(userId);
        return users.isEmpty() ? null : users.get(0);
    }


    public User addUser(User user){
        return repository.save(user);
    }

    public void deleteAllByUserId(Integer userId){
        repository.deleteAllByUserId(userId);
    }

    public long countAll(){
        return repository.count();
    }

    public Long countBySex(Boolean sex){
        return repository.countAllBySex(sex);
    }
}
