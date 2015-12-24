package com.chen.learn.ch05;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class DownloadServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        ServletContext context = getServletContext();
        String downloadPath = "/WEB-INF/classes/ch05/";
        OutputStream out = resp.getOutputStream();

        if(filename == null){
            out.write("Please input filename".getBytes());
            out.flush();
            out.close();
        }

        InputStream in = getServletContext().getResourceAsStream(downloadPath + filename);
        int length = in.available();

        //设置响应正文的MIME类型
        resp.setContentType("application/force-download");
        resp.setHeader("Content-Length", String.valueOf(length));
        resp.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\" ");

        // 把本地文件中的数据发送给客户
        int bytesRead;
        byte[] buffer = new byte[512];
        while( (bytesRead = in.read(buffer)) != -1){
            out.write(buffer, 0 ,bytesRead);
        }
        in.close();
        out.close();
    }
}
