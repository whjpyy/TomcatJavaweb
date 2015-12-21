package com.chen.learn.ch04;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("application is Initialized.");
        // 获取ServletContext对象
        ServletContext context = servletContextEvent.getServletContext();

        try{
            // 从文件中读取计数器的数值
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResourceAsStream("/WEB-INF/classes/ch04/count.txt")));
            int count = Integer.parseInt(reader.readLine());
            reader.close();

            // 创建计数器对象
            Count counter = new Count(count);
            context.setAttribute("count", counter);
        } catch (Exception e) {
            e.printStackTrace();
            context.setAttribute("count", new Count(0));
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("application is Destroyed.");

        // 获取ServletContext对象
        ServletContext context = servletContextEvent.getServletContext();

        // 从web应用范围获得计数器对象
        Count counter = (Count)context.getAttribute("count");

        if(counter != null){
            try{
                String path = context.getRealPath("/");
                int target = path.indexOf("\\target");
                path = path.substring(0, target) + "\\src\\main\\resources\\ch04\\count.txt";
                PrintWriter writer = new PrintWriter(path);
                writer.println(counter.getCount());
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
