package com.lzh.template.service;


import com.lzh.template.exception.GreetingException;
import com.lzh.template.vo.Person;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 问候服务
 *
 * @author jimmy 523160615@qq.com
 */
public interface GreetingService
{
    /**
     * 向某人打招呼
     * @param person
     * @param message
     * @throws GreetingException
     */
    public void sayHello(@NotEmpty Person person,@NotNull String message) throws GreetingException;
}