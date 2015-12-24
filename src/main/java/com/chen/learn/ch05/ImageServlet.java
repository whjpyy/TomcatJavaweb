package com.chen.learn.ch05;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-12-24.
 */
public class ImageServlet extends HttpServlet {

    private Font font = new Font("Courier", Font.BOLD, 12); //字体

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到待显示的数字
        String count = req.getParameter("count");
        if(count == null) count = "1";

        int len = count.length(); // 数字长度
        resp.setContentType("image/jpeg"); // 设置响应正文的类型
        ServletOutputStream out = resp.getOutputStream();
        // 创建一个位于缓存中的图像，长为11*len, 高为16
        BufferedImage bufferedImage = new BufferedImage(11 * len, 16, BufferedImage.TYPE_INT_RGB);

        // 获得Grapic画笔
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.BLACK);
        // 画一个黑色的矩形，长为11*len，高为16
        g.fillRect(0, 0, 11*len, 16);
        g.setColor(Color.WHITE);
        g.setFont(font);
        char c;
        for(int i = 0;i < len;i ++){
            c = count.charAt(i);
            g.drawString(c + "", i*11+1,12); // 写一个白色的数字
            g.drawLine((i + 1) * 11 - 1, 0, (i + 1) * 11 - 1, 16); //画一条白色的线
        }

        // 输出JPEG格式的图片
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bufferedImage);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
