package com.lzh.template.exception;

/**
 * 问候异常
 *
 * @author jimmy 523160615@qq.com
 */
public class GreetingException extends Exception
{
    public GreetingException(String message)
    {
        super(message);
    }

    public GreetingException()
    {
    }

    public GreetingException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public GreetingException(Throwable cause)
    {
        super(cause);
    }

    public GreetingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
