package com.chen.learn.ch04;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class CounterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        Count count = (Count)context.getAttribute("count");
        if(count == null){
            count = new Count(1);
            context.setAttribute("count", count);
        }
        count.add(1);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.print("本网页第" + count.getCount() + "次被访问！");
        out.close();
    }
}
