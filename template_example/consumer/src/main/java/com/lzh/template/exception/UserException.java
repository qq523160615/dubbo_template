package com.lzh.template.exception;

/**
 * 用户异常
 *
 * @author jimmy 523160615@qq.com
 */
public class UserException extends Exception
{
    public UserException(String message)
    {
        super(message);
    }

    public UserException()
    {
    }

    public UserException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserException(Throwable cause)
    {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}


