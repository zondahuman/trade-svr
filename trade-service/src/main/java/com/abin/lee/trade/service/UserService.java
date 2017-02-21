package com.abin.lee.trade.service;


import com.abin.lee.trade.model.User;
import com.abin.lee.trade.model.vo.response.UserVo;
import com.abin.lee.trade.service.base.BaseService;

/**
 * Created by zhoujiuping on 2016/12/7.
 */
public interface UserService extends BaseService<User> {

    User save(UserVo userVo);

    UserVo findByUserKey(String userKey);

    User load(String userKey);

    UserVo loadByChannelCodeAndrefId(String channelCode, String idNo);

    User loadByChannelCodeAndUserKey(String channelCode, String userKey);

    /**
     * 获取有效的用户
     * 
     * @param channelCode
     * @param userKey
     * @return
     */
    User loadValidByChannelCodeAndUserKey(String channelCode, String userKey);

    User load(Long id, String channelCode);

    /**
     * 验证用户
     * 
     * @param channel
     * @param userKey
     * @return
     */
    User checkUser(String channel, String userKey);

}
