package com.chen.learn.ch13;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by YouZeng on 2016-01-04.
 */
public class LoadServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        Properties ps = new Properties();
        Properties ps_ch = new Properties();
        try{
            ServletContext context = getServletContext();
            InputStream in = context.getResourceAsStream("/WEB-INF/classes/ch13/messageresource.properties");
            ps.load(in);
            InputStream in_ch = context.getResourceAsStream("/WEB-INF/classes/ch13/messageresource_ch.properties");
            ps_ch.load(in_ch);
            context.setAttribute("ps", ps);
            context.setAttribute("ps_ch", ps_ch);

            in.close();
            in_ch.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        PrintWriter out = resp.getWriter();
        out.println("The source file is reloaded.");
        out.close();
    }
}
