package com.example.superkassa;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MyService {
    private final IRepository repository;

    public MyService(IRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_READ)
    public MyJson changeCurrent(Integer id, Integer add) {
        Optional<MyEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            int value = entity.get().getObj().getCurrent() + add;
            entity.get().getObj().setCurrent(value);
            repository.save(entity.get());
            return entity.get().getObj();
        } else return null;
    }
}
