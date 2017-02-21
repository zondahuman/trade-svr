package com.abin.lee.trade.dao;


import com.abin.lee.trade.dao.repository.BaseRepository;
import com.abin.lee.trade.model.User;

/**
 * Created by zhoujiuping on 2016/12/7.
 */
public interface UserRepository extends BaseRepository<User> {

    User findByUserKey(String userKey);

    User findByChannelCodeAndRefId(String code, String refId);

    User findByIdAndChannelCode(Long id, String channelCode);

    User findByChannelCodeAndUserKey(String channelCode, String userKey);

}
