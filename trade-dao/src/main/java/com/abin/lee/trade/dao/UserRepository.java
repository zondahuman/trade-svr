package com.abin.lee.trade.dao;


import com.abin.lee.trade.dao.repository.BaseRepository;
import com.abin.lee.trade.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by zhoujiuping on 2016/12/7.
 */
public interface UserRepository extends BaseRepository<User> {

    User findByUserKey(String userKey);

    User findByChannelCodeAndRefId(String code, String refId);

    User findByIdAndChannelCode(Long id, String channelCode);

    User findByChannelCodeAndUserKey(String channelCode, String userKey);

    Page<User> findByRemark(String remark, Pageable pageable);

    List<User> findByRemark(String remark, Sort sort);

}
