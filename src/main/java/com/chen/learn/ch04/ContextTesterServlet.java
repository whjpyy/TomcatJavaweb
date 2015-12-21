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
public class ContextTesterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>ContextTesterServlet</title></head>");
        out.println("<body>");
        out.println("<br />context-param[email]: " + context.getInitParameter("email"));
        out.println("<br />Path: " + context.getRealPath("/WEB-INF"));
        out.println("<br />getResource[/WEB-INF]: " + context.getResource("/WEB-INF"));
        out.println("<br />getResource[/index.jsp]: " + context.getResource("/index.jsp"));
        out.println("<br />MimeType: " + context.getMimeType("/WEB-INF/web.xml"));
        out.println("<br />MajorVersion: " + context.getMajorVersion());
        out.println("<br />MinorVersion: " + context.getMinorVersion());
        out.println("<br />ServerInfo: " + context.getServerInfo());
        out.println("<br />getServletContextName: " + context.getServletContextName());
        out.println("</body></html>");

        context.log("这是ContextTesterServlet输出的日志");
        out.close();
    }
}
