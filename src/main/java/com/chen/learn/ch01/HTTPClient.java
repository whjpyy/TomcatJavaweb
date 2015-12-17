package com.chen.learn.ch01;

import java.io.*;
import java.net.Socket;

/**
 * Created by YouZeng on 2015-11-26.
 */
public class HTTPClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        String uri = "index.htm";
        if(args.length != 0){
            uri = args[0];
        }
        doGet("127.0.0.1", 8080, uri);
    }

    /**
     * 按照GET请求方式访问HTTPServer
     * @param host
     * @param port
     * @param uri
     */
    private static void doGet(String host, int port, String uri) throws IOException, InterruptedException {
        Socket socket = new Socket(host, port);

        // 创建HTTP请求
        StringBuffer sb = new StringBuffer("GET " + uri + " HTTP/1.1\r\n");
        // HTTP请求头
        sb.append("Accept: */*\r\n");
        sb.append("Accpet-Language: zh-cn\r\n");
        sb.append("Accept-Encoding: gzip, deflate\r\n");
        sb.append("User-Agent: HTTPClient\r\n");
        sb.append("Host: localhost:8080\r\n");
        sb.append("Connection: Keep-Alive\r\n\r\n");

        // 发送HTTP请求
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(sb.toString().getBytes());

        Thread.sleep(2000);

        // 读取响应内容
        InputStream inputStream = socket.getInputStream();
        int len = inputStream.available();
        byte[] buffer = new byte[len];
        inputStream.read(buffer);
        System.out.println(new String(buffer));
        socket.close();
    }
}
