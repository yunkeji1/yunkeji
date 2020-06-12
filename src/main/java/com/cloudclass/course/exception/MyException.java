package com.cloudclass.course.exception;
/**
 * 自定义 异常
 * @author ss
 * @date 2020-6-12
 */
public class MyException extends RuntimeException{
    private static final long serialVersionUID = -13345478421L;
    public MyException() {
        super();
    }
    public MyException(String msg) {
        super(msg);
    }
    public MyException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public MyException(Throwable cause) {
        super(cause);
    }
}
