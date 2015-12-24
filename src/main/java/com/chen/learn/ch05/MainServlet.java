package com.chen.learn.ch05;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-24.
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置HTTP响应的正文的数据类型
        resp.setContentType("text/html");

        // 输出HTML文档
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>MainServlet</title></head><body>");

        ServletContext context = getServletContext();

        RequestDispatcher dispatcherHead = context.getRequestDispatcher("/page/ch05/header.html");
        RequestDispatcher dispatcherGreet = context.getRequestDispatcher("/greet");
        RequestDispatcher dispatcherFooter = context.getRequestDispatcher("/page/ch05/footer.html");

        // 包含
        dispatcherHead.include(req, resp);
        dispatcherGreet.include(req, resp);
        dispatcherFooter.include(req, resp);

        out.println("</body></html>");
        out.close();
    }
}
