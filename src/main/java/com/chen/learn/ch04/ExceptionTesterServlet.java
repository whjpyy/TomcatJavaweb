package com.chen.learn.ch04;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class ExceptionTesterServlet extends GenericServlet{

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String condition = request.getParameter("condition");
        if(condition == null){
            condition = "ok";
        }else if("1".equals(condition)){
            throw new ServletException("condition1");
        }else if("2".equals(condition)){
            throw new UnavailableException("condition2", 2);
        }else if("3".equals(condition)){
            throw new UnavailableException("conidition3");
        }

        PrintWriter out = response.getWriter();
        out.println("It's Ok");
        out.close();
    }
}
