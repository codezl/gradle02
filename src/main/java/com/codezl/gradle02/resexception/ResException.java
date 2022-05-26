package com.codezl.gradle02.resexception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/29/15:58
 * @Description:
 */
public class ResException extends RuntimeException{
    public ResException() {
        super();
    }

    public ResException(String message) {
        super(message);
    }
}
