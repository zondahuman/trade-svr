package com.abin.lee.trade.service.base.impl;

import com.abin.lee.trade.dao.repository.BaseRepository;
import com.abin.lee.trade.model.base.BaseModel;
import com.abin.lee.trade.service.base.BaseService;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel, R extends BaseRepository<T>> implements BaseService<T> {

    protected R repository;

    protected abstract void setRepository(R repository);

    protected T save(T entity) {

        Date date = new Date();

        entity.setCreateTime(date);
        entity.setUpdateTime(date);

        return repository.save(entity);
    }

    protected T update(T entity) {

        Date date = new Date();

        entity.setUpdateTime(date);

        return repository.save(entity);
    }

    @Override
    public T get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public T load(Long id) {
        T entity = get(id);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

}
