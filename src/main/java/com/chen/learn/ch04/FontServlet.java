package com.chen.learn.ch04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class FontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        if(word != null){
            word = new String(word.getBytes("ISO-8859-1"), "utf-8");
        }else{
            word = "Hello";
        }
        String color = req.getParameter("color");
        String size = req.getParameter("size");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>FontServet</title></head>");
        out.println("<body>");
        out.println("<font size=" + size + " color=" + color + ">" + word + "</font>");
        out.println("<br />ServletName: " + getServletName());
        out.println("<br />草泥马");
        out.println("</body></html>");
        out.close();
    }
}
