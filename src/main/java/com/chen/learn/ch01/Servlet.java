package com.chen.learn.ch01;

import java.io.OutputStream;

/**
 * Created by YouZeng on 2015-11-30.
 */
public interface Servlet {
    public void init() throws Exception;
    public void service(byte[] bytes, OutputStream outputStream) throws Exception;
}
