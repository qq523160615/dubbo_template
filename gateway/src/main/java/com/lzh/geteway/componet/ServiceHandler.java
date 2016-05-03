package com.lzh.geteway.componet;


import com.lzh.geteway.extension.Request;
import com.lzh.geteway.extension.Response;

/**
 * 服务处理器
 *
 * @author nico huangwenzeng1@163.com
 */
public interface ServiceHandler
{
    /**
     * 返回服务名
     */
    String supportServiceName();

    /**
     * 处理请求
     *
     * @param request 请求参数
     * @return 返回实体
     * @throws Exception 异常处理
     */
    Response handle(Request request) throws Exception;

}
