package com.chen.learn.ch04;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class QuestionServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet is initialized");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext  context = getServletContext();
        PrintWriter out = servletResponse.getWriter();
        out.println(context.getServerInfo());
        out.close();
    }
}
