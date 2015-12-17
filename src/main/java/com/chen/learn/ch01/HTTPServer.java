package com.chen.learn.ch01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YouZeng on 2015-11-26.
 */
public class HTTPServer {
    // servet对象缓存池
    private static Map<String, Servlet> servletMap = new HashMap<String, Servlet>();

    public static void main(String[] args) {
        int port;
        ServerSocket serverSocket;

        try{
            port = Integer.parseInt(args[0]);
        }catch (Exception e){
            System.out.println("port = 8080 (默认)");
            port = 8080;
        }

        try{
            serverSocket = new ServerSocket(port);
            System.out.println("服务器正在监听端口：" + serverSocket.getLocalPort());

            while(true){
                // 等待客户端的TCP连接
                final Socket socket = serverSocket.accept();
                System.out.println("建立了与客户的一个新的TCP连接，该客户的地址为：" +
                    socket.getInetAddress() + ": " + socket.getPort());
                service(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 相应客户端的HTTP请求
     * @param socket
     */
    private static void service(Socket socket) throws Exception{
        // 读取HTTP请求信息
        InputStream inputStream = socket.getInputStream();
        Thread.sleep(500);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        String reqeust = new String(buffer);
        System.out.println(reqeust);    // 打印HTTP请求信息

        // 解析HTTP请求信息
        String firstLineOfRequest = reqeust.substring(0, reqeust.indexOf("\r\n"));
        // 解析HTTP请求的第一行
        String[] parts = firstLineOfRequest.split(" ");
        String uri = parts[1];


        /* 处理Servlet请求 */
        if(uri.startsWith("/servlet")){
            String servletName;
            // 获取请求servlet类的名称
            if(uri.indexOf("?") == -1) {
                servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.length());
            }else{
                servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.indexOf("?"));
            }
            // 从缓冲池中获取servet对象
            Servlet servlet = servletMap.get(servletName);
            if(servlet == null){
                //生成servlet对象并存储到缓冲池中
                servlet = (Servlet)Class.forName("com.chen.learn.ch01." + servletName).newInstance();
                servlet.init();
                servletMap.put(servletName, servlet);
            }
            // 调用servlet的service方法
            servlet.service(buffer, socket.getOutputStream());
            socket.close();
            return;
        }

        String contentType;
        if(uri.indexOf("html") != -1 || uri.indexOf("htm") != -1){
            contentType = "text/html";
        }else if(uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1){
            contentType = "image/jpeg";
        }else if(uri.indexOf("gif") != -1){
            contentType = "immage/gif";
        }else {
            contentType = "application/octet-stream";   // 字节流类型
        }

        /* 创建HTTP响应结果 */
        // HTTP响应的第一行
        String responseFirstLine = "HTTP/1.1 200 OK\r\n";
        // HTTP响应头
        String responseHeader = "Content-type:" + contentType + "\r\n\r\n";
        // 获得读取响应正文数据的输入流
        InputStream in = HTTPServer.class.getResourceAsStream("/ch01/" + uri);

        if(in != null) {
            /* 发送HTTP响应的结果 */
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(responseFirstLine.getBytes());
            outputStream.write(responseHeader.getBytes());
            // 发送HTTP响应的正文
            int len = 0;
            buffer = new byte[128];
            while ((len = in.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        }
        Thread.sleep(1000);
        socket.close();
    }
}
