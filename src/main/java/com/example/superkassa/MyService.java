package com.example.superkassa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MyService {
    private final IRepository repository;

    public MyService(IRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MyJson changeCurrent(Integer id, Integer add) {
        MyEntity entity = repository.findById(id).orElse(null);
        assert entity != null;
        AtomicInteger atomicInteger = new AtomicInteger(entity.getObj().getCurrent());
        entity.getObj().setCurrent(atomicInteger.addAndGet(add));
        repository.save(entity);
        return entity.getObj();
    }
}
