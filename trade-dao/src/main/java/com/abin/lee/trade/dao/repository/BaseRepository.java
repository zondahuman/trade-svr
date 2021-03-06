package com.abin.lee.trade.dao.repository;

import com.abin.lee.trade.model.base.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long>, PagingAndSortingRepository<T,Long> { }
