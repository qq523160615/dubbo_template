package com.lzh.geteway.componet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lzh.geteway.extension.Request;
import com.lzh.geteway.extension.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * api入口控制器
 *
 * @author nico huangwenzeng1@163.com
 */
@Controller
public class Entrance
{
    //服务接口实现列表
    @Autowired
    private List<ServiceHandler> handlers;

    //已服务名为key保存接口
    private Map<String, ServiceHandler> mapping;

    //加密
    @Autowired
    Encryptor encryptor;

    //加密key
    @Value("${aes.key}")
    String ASE_KEY;

    //是否开启加密
    @Value("${encrypotor.is}")
    boolean IS_ENCRYPOTOR;

    /**
     * 把服务保存到map中,以服务名为key
     */
    @PostConstruct
    public void init()
    {
        mapping = new HashMap<String, ServiceHandler>();
        for (ServiceHandler handler : handlers)
        {
            mapping.put(handler.supportServiceName(), handler);
        }
    }

    /**
     * 处理请求
     *
     * @param httpServletRequest 请求数据
     * @return 返回数据
     */
    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json;charset=UTF-8"
    )
    public byte[] handle(HttpServletRequest httpServletRequest)
    {
        //应答实体
        Response response = new Response();
        //返回字符串
        byte[] data = null;

        try
        {
            //获取数据字符数组
            byte[] content = getRequestPostBytes(httpServletRequest);

            String result;
            //判断是否开启加密
            if (IS_ENCRYPOTOR)
            {
                //解密数据
                result = new String(encryptor.decode(content, ASE_KEY), "UTF-8");
                System.out.println(result);
            }
            else
            {
                //不解密数据
                result = new String(content, "UTF-8");
            }

            //获取请求实体
            Request request = JSON.parseObject(result, Request.class);

            //根据服务名获取对应的服务实现
            ServiceHandler handler = mapping.get(request.getServiceName());

            //找不到服务
            if (handler == null)
            {
                response.setStatus(Response.STATUS_FAILURE);
                response.setErrorMessage("找不到该接口");
            }
            else
            {
                //根据服务进行相应的操作
                response = handler.handle(request);
            }

            //返回数据

            if (IS_ENCRYPOTOR)
            {
                //加密数据
                data = encryptor.encode(JSON.toJSONString(
                        response, SerializerFeature.WriteMapNullValue).getBytes(),
                        ASE_KEY
                );
            }
            else
            {
                data = JSON.toJSONString(response, SerializerFeature.WriteMapNullValue).getBytes();
            }


        }
        catch (Exception e)
        {
            response.setStatus(Response.STATUS_FAILURE);
            response.setErrorMessage(e.getMessage());
            data = JSON.toJSONString(response, SerializerFeature.WriteMapNullValue).getBytes();

            if (IS_ENCRYPOTOR)
            {
                data = new String(encryptor.encode(data, ASE_KEY)).getBytes();
            }
        }

        return data;
    }

    /**
     * 请求参数转成字节数组
     *
     * @param request 请求
     * @return 字节数组
     * @throws IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException
    {
        int contentLength = request.getContentLength();
        /*当无请求参数时，request.getContentLength()返回-1 */
        if (contentLength < 0)
        {
            return new byte[]{};
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; )
        {

            int readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1)
            {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
}
