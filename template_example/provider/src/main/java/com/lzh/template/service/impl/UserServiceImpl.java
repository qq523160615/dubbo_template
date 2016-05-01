package com.lzh.template.service.impl;

import com.lzh.template.exception.UserException;
import com.lzh.template.manager.UserManager;
import com.lzh.template.service.UserService;
import com.lzh.template.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 用户服务
 *
 * @author jimmy
 */
@Component("service.user")
@Validated
public class UserServiceImpl implements UserService
{
    @Autowired
    UserManager userManager;

    public UserVO login(@NotNull String s, @NotNull String s1) throws UserException
    {
        return userManager.login();
    }

    public String getCode(@NotNull String s) throws UserException
    {
        return userManager.getCode();
    }
}
