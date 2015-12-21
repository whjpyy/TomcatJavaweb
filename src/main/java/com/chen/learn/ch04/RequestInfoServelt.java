package com.chen.learn.ch04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class RequestInfoServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response.getCharacterEncoding: " + resp.getCharacterEncoding());

        String username = req.getParameter("username");
        if(username == null){
            resp.sendError(resp.SC_FORBIDDEN);
            return;
        }else{
            username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        }

        // 设置HTTP响应的正文的数据类型
        resp.setContentType("text/html;charset=utf-8");

        // 输出HTML文档
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>RequestInfo</title></head>");
        out.println("<body>");
        out.println("<br />LocalAddr: " + req.getLocalAddr());
        out.println("<br />LocalName: " + req.getLocalName());
        out.println("<br />LocalPort: " + req.getLocalPort());
        out.println("<br />Protocol: " + req.getProtocol());
        out.println("<br />RemoteAddr: " + req.getRemoteAddr());
        out.println("<br />RemoteHost: " + req.getRemoteHost());
        out.println("<br />RemotePort: " + req.getRemotePort());

        out.println("<br />Mehtod: " + req.getMethod());
        out.println("<br />URI: " + req.getRequestURI());
        out.println("<br />ContextPath: " + req.getContextPath());
        out.println("<br />QueryString: " + req.getQueryString());

        out.println("<br />***打印HTTP请求头***");
        Enumeration enumeration = req.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String headerName = (String)enumeration.nextElement();
            out.println("<br />" + headerName + ": " + req.getHeader(headerName));
        }
        out.println("<br />***打印HTTP请求头结束***");

        // 打印请求参数username
        out.println("<br />username: " + username);

        out.close();

        super.doGet(req, resp);
    }
}
