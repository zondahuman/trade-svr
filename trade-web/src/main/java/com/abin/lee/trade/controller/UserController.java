package com.abin.lee.trade.controller;

import com.abin.lee.trade.model.User;
import com.abin.lee.trade.model.vo.response.UserVo;
import com.abin.lee.trade.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@Api("用户推送")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "userVo", value = "用户详细实体UserVo", required = true, dataType = "UserVo")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody UserVo userVo) {
        String result = "FAILURE";
        try {
            this.userService.save(userVo);
            result = "SUCCESS";
        } catch (Exception e) {
            log.error("e: ", e);
        }
        return result;
    }

    @ApiOperation(value="用户查询", notes="根据id查询用户")
    @ApiImplicitParam(name = "id", value = "用户主键id", required = true, dataType = "Long")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public User find(@RequestBody Long id) {
        User user = null;
        try {
            user = this.userService.load(id);
        } catch (Exception e) {
            log.error("e: ", e);
        }
        return user;
    }

}
