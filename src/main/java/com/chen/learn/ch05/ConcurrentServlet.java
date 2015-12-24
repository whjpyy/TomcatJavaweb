package com.chen.learn.ch05;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-24.
 */
public class ConcurrentServlet extends HttpServlet {

    private String username; //实例变量

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = req.getParameter("username");
        if(username != null){
            // 字符编码转换
            username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        }
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>ConcurrentServlet</title></head><body>");
        out.println("你好：" + username);
        out.println("</body></html>");
        out.close();
    }
}
