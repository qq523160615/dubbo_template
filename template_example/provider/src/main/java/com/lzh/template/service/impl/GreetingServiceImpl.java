package com.lzh.template.service.impl;

import com.lzh.template.exception.GreetingException;
import com.lzh.template.service.GreetingService;
import com.lzh.template.vo.Person;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 打招呼服务
 *
 * @author Jimmy 523160615@qq.com
 */
public class GreetingServiceImpl implements GreetingService
{
    public void sayHello(@NotEmpty Person person, @NotNull String s) throws GreetingException
    {
        System.out.println(person.getName() + "say:   " + s);
    }
}
