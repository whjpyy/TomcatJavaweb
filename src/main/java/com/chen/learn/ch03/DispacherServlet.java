package com.chen.learn.ch03;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-12-18.
 */
public class DispacherServlet extends GenericServlet{
    private String target = "/page/ch03/hello.jsp";

    /**
     * 响应客户请求
     * @param req 请求参数
     * @param res 返回参数
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        req.setAttribute("USER", username);
        req.setAttribute("PASSWORD", password);

        // 把请求转发给hello.jsp
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(req, res);
    }
}
