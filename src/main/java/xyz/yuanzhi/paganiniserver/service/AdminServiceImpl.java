package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.AdminRepository;

@Service
public class AdminServiceImpl {

    @Autowired
    private AdminRepository repository;

    public Boolean searchAdmin(String name, String password){
        return repository.existsByNameAndPassword(name, password);
    }
}
