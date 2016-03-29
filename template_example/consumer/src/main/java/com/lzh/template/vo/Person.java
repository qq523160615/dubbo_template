package com.lzh.template.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 人
 *
 * @author jimmy 523160615@qq.com
 */
public class Person implements Serializable
{
    //姓名
    @JSONField(name = "name")
    private String name;

    //地址
    @JSONField(name = "address")
    private String address;

    //年龄
    @JSONField(name = "age")
    private Integer age;

    //手机号码
    @JSONField(name = "phone")
    private String phone;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
