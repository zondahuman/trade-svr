package com.abin.lee.trade.service.base;

import com.abin.lee.trade.model.base.BaseModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BaseService<T extends BaseModel> {

    T get(Long id);

    T load(Long id);

    List<T> findAll();

    List<T> findAll(Sort sort);

}
