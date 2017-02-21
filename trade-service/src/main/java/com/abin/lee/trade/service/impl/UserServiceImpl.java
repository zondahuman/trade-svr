package com.abin.lee.trade.service.impl;

import com.abin.lee.trade.common.constant.UserType;
import com.abin.lee.trade.common.constant.ValidStatus;
import com.abin.lee.trade.common.util.UniqueKeyUtils;
import com.abin.lee.trade.dao.UserRepository;
import com.abin.lee.trade.model.User;
import com.abin.lee.trade.model.vo.response.UserVo;
import com.abin.lee.trade.service.UserService;
import com.abin.lee.trade.service.base.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhoujiuping on 2016/12/7.
 */
@Transactional
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {

    @Autowired
    @Override
    protected void setRepository(UserRepository repository) {
        super.repository = repository;
    }


    @Override
    public User save(UserVo userVo) {
        checkParam(userVo);

        User user = new User();
        user.setUserKey(UniqueKeyUtils.uniqueKey());
        user.setRefId(userVo.getRefId());
        // 身份证号，保存时转大写
        user.setIdNo(userVo.getIdNo().toUpperCase());
        user.setChannelCode(userVo.getChannelCode());
        user.setUserType(UserType.COMMON);
        user.setStatus(ValidStatus.ENABLE);
        user.setRemark(userVo.getRemark());

        return save(user);
    }

    @Override
    protected User save(User entity) {
        super.save(entity);
        return entity;
    }

    @Override
    protected User update(User entity) {
        super.update(entity);
        return entity;
    }

    @Override
    public UserVo findByUserKey(String userKey) {
        User user = repository.findByUserKey(userKey);
        return getUserVo(user);
    }

    @Override
    public User load(String userKey) {
        User user = repository.findByUserKey(userKey);
        return user;
    }

    private UserVo getUserVo(User user) {
        if (user == null) {
            return null;
        }
        UserVo vo = new UserVo();

        vo.setUseKey(user.getUserKey());
        vo.setIdNo(user.getIdNo());
        vo.setChannelCode(user.getChannelCode());
        vo.setUserType(user.getUserType());
        vo.setStatus(user.getStatus());
        vo.setRemark(user.getRemark());
        vo.setRefId(user.getRefId());
        return vo;
    }

    @Override
    public UserVo loadByChannelCodeAndrefId(String channelCode, String refId) {
        User user = repository.findByChannelCodeAndRefId(channelCode, refId);
        return getUserVo(user);
    }

    @Override
    public User loadByChannelCodeAndUserKey(String channelCode, String userKey) {
        User user = repository.findByChannelCodeAndUserKey(channelCode, userKey);
        return user;
    }

    @Override
    public User loadValidByChannelCodeAndUserKey(String channelCode, String userKey) {
        User user = loadByChannelCodeAndUserKey(channelCode, userKey);
        return user;
    }

    @Override
    public User load(Long id, String channelCode) {
        User user = this.repository.findByIdAndChannelCode(id, channelCode);
        return user;
    }

    @Override
    public User checkUser(String channel, String userKey) {
        // 用户key不能为空

        User user = this.load(userKey);

        if (StringUtils.isNotBlank(channel) && !user.getChannelCode().equals(channel)) {
            throw new RuntimeException("5555555555");
        }
        return user;
    }

    private void checkParam(UserVo vo) {
        User user = repository.findByChannelCodeAndRefId(vo.getChannelCode(), vo.getRefId());
    }

}
