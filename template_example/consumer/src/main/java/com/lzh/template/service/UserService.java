package com.lzh.template.service;


import com.lzh.template.exception.UserException;
import com.lzh.template.vo.UserVO;

import javax.validation.constraints.NotNull;

/**
 * 用户管理服务
 *
 * @author jimmy 523160615@qq.com
 */
public interface UserService
{
    /**
     * 登录
     *
     * @param phone 账号
     * @param code  验证码
     * @return
     */
    UserVO login(@NotNull String phone, @NotNull String code) throws UserException;

    /**
     * 获取验证码
     *
     * @param phone
     * @return
     */
    String getCode(@NotNull String phone) throws UserException;
}



