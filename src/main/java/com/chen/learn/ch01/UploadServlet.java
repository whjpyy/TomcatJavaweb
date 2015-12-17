package com.chen.learn.ch01;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.StringReader;

/**
 * Created by YouZeng on 2015-12-01.
 */
public class UploadServlet implements Servlet {

    @Override
    public void init() throws Exception {
        System.out.println("Upload is init...");
    }

    @Override
    public void service(byte[] bytes, OutputStream outputStream) throws Exception {
        String request = new String(bytes);
        // 获取请求头
        String headerOfRequest = request.substring(request.indexOf("\r\n") + 2, request.indexOf("\r\n\r\n"));
        BufferedReader br = new BufferedReader(new StringReader(headerOfRequest));
        String data, boundary = "";
        // 获取boundary
        while( (data = br.readLine()) != null){
            if(data.indexOf("Content-Type") != -1){
                boundary = data.substring(data.indexOf("boundary=") + 9, data.length()) + "\r\n";
                break;
            }
        }

        if(boundary == null){
            outputStream.write("HTTP/1.1 200 OK/r/n".getBytes());
            outputStream.write("Content-Type:text/html/r/n/r/n".getBytes());
            outputStream.write("FileUpload is failed".getBytes());
        }

        int index1OfBoundary = request.indexOf(boundary);
        int index2OfBoundary = request.indexOf(boundary, index1OfBoundary + boundary.length());
        int index3OfBoundary = request.indexOf(boundary, index2OfBoundary + boundary.length());

  /*      // 文件部分的头的第一行结束后的位置
        int afterOfFilePartLine1 = request.indexOf("\r\n", index2OfBoundary + boundary.length());
        // 文件部分的头第一行
        String header1OfFilePart = request.substring(index2OfBoundary + boundary.length(), afterOfFilePartLine1);
        // 上传文件的名字
        String fileName = header1OfFilePart.substring(header1OfFilePart.lastIndexOf("=") + 2, header1OfFilePart.length() - 1);

        //文件部分正文部分的开头位置
        int len1 = request.indexOf("\r\n\r\n", index2OfBoundary);
        //文件部分的正文
        String fileContent = request.substring(len1+1, index3OfBoundary-2);
        //保存文件到服务器
        FileOutputStream fos = new FileOutputStream("target\\classes\\ch01\\" + fileName);
        fos.write(fileContent.getBytes());
        fos.close();*/

        //创建并发送HTTP响应
        outputStream.write("HTTP/1.1 200 OK/r/n".getBytes());
        outputStream.write("Content-Type:text/html\r\n\r\n".getBytes());
        // 响应正文
        outputStream.write("<html><head><title>HelloWorld</title></head>".getBytes());
        outputStream.write(("<h1>Upload is finished.</h1></ br>").getBytes());
        ;/*outputStream.write(("<h1>FileName:" + fileName + "</h1></ br>").getBytes())
        outputStream.write(("<h1>FileContent: " + fileContent + "</h1>").getBytes());*/
    }


}
