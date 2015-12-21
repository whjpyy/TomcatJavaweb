package com.chen.learn.ch04;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class LifeServlet extends GenericServlet {

    private int initVar = 0;
    private int serviceVar = 0;
    private int destoryVar = 0;
    private String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getServletName();
        initVar++;
        System.out.println(name + " > init(): Servlet被初始化了" + initVar + "次");
    }

    @Override
    public void destroy() {
        destoryVar++;
        System.out.println(name + " > destroy(): Servlet被销毁了" + destoryVar + "次");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        serviceVar++;
        System.out.println(name + " > service(): Servlet工响应了" + serviceVar + "次");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<h1>初始化次数：" + initVar + "</h1>");
        out.print("<h1>响应客户请求次数：" +  serviceVar + "</h1>");
        out.print("<h1>销毁次数" + destoryVar + "</h1>");

        out.close();
    }
}
