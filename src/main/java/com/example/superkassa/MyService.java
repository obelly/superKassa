package com.example.superkassa;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {
    private final IRepository repository;

    public MyService(IRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_READ)
    public MyJson changeCurrent(Integer id, Integer add) {
        MyEntity entity = repository.findById(id).orElse(null);
        assert entity != null;
        int value = entity.getObj().getCurrent() + add;
        entity.getObj().setCurrent(value);
        repository.save(entity);
        return entity.getObj();
    }
}
