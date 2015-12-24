package com.chen.learn.ch05;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-24.
 */
public class CookieServlet extends HttpServlet {
    int count = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(int i = 0;i < cookies.length;i ++){
                out.println("Cookie name: " + cookies[i].getName());
                out.println("Cookie value: " + cookies[i].getValue());
                out.println("Max Age: " + cookies[i].getMaxAge() + "\r\n");
            }
        }else{
            out.println("No cookies");
        }
        count++;
        // 向客户端写一个Cookie
        resp.addCookie(new Cookie("cookieName" + count, "cookieValue" + count));
    }
}
