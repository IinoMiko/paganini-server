package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yuanzhi.paganiniserver.dao.CollectRepository;
import xyz.yuanzhi.paganiniserver.domain.Collect;

import java.util.List;

@Service
public class CollectServiceImpl {

    @Autowired
    private CollectRepository repository;

    public List<Collect> getAllCollects(Integer id){
        return repository.findAllByUserIdAndType(id, Collect.USER_LIST);
    }

    public Collect addCollect(Collect collect){
        return repository.save(collect);
    }

    public Boolean existsByCollectId(Integer collectId){
        return repository.existsByCollectId(collectId);
    }

    public Collect save(Collect collect){
        return repository.save(collect);
    }

    public void deleteByCollectId(Integer collectId){
        repository.deleteByCollectId(collectId);
    }

    public List<Collect> getAllSystemList(){
        return repository.getAllSystemList();
    }
}
