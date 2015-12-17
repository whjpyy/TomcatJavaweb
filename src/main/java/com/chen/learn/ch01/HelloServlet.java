package com.chen.learn.ch01;

import java.io.OutputStream;

/**
 * Created by YouZeng on 2015-11-30.
 */
public class HelloServlet implements Servlet {

    @Override
    public void init() throws Exception {
        System.out.println("HelloServlet init...");
    }

    @Override
    public void service(byte[] bytes, OutputStream outputStream) throws Exception {
        String buffer = new String(bytes);

        // 获取请求信息第一行
        String request = buffer.substring(0, buffer.indexOf("\r\n"));
        String method = request.split(" ")[0];
        String uri = request.split(" ")[1];

        String username = "";
        // Get方式获取username
        if(method.equalsIgnoreCase("get") && uri.indexOf("username") != -1){
            String param = uri.substring(uri.indexOf("?") + 1, uri.length());
            String[] params = param.split("&");
            username = params[0].split("=")[1];
        //Post方式获取username
        }else if(method.equalsIgnoreCase("post")){
            // 请求体
            String content = buffer.substring(buffer.indexOf("\r\n\r\n") + 4, buffer.length());
            if(content.indexOf("username") != -1) {
                String[] params = content.split("&");
                username = params[0].split("=")[1];
            }
        }

        // 创建并发送HTTP响应
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        outputStream.write("Content-Type: text/html\r\n\r\n".getBytes());
        outputStream.write("<html><head><title>Hello</title></head>".getBytes());
        outputStream.write(("<body><h1>Hello:" + username + "</h1></body></html>").getBytes());
    }
}
