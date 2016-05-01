package com.lzh.template.manager;


import com.lzh.template.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * 用户管理类
 *
 * @author jimmy
 */
@Component
public class UserManager
{
    public UserVO login()
    {
        UserVO user = new UserVO();
        user.setId("1");
        user.setName("name");
        user.setAddress("address");
        user.setAge(12);
        user.setPhone("15902078327");

        return user;
    }


    public String getCode()
    {
        return "123456";
    }
}
