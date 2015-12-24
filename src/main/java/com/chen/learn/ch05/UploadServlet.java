package com.chen.learn.ch05;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YouZeng on 2015-12-24.
 */
public class UploadServlet extends HttpServlet{

    private String filePath; // 存放上传文件的目录
    private String tempFilePath; // 存放临时文件的目录

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        filePath = config.getInitParameter("filePath"); // 读取初始化参数uploadPath
        tempFilePath = config.getInitParameter("tempFilePath");
        filePath = getServletContext().getRealPath(filePath);
        tempFilePath = getServletContext().getRealPath(tempFilePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        try{
            // 创建一个机遇硬盘的FileItem工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置向硬盘写数据时所用的缓冲区的大小，此处为4K
            factory.setSizeThreshold(4 * 1024);
            // 设置临时目录
            factory.setRepository(new File(tempFilePath));

            // 创建一个文件上传处理器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置运行上传的文件的最大尺寸
            upload.setSizeMax(4 * 1024 * 1024);

            List<FileItem> items = upload.parseRequest(req);
            Iterator<FileItem> iter = items.iterator();
            while(iter.hasNext()){
                FileItem fi = iter.next();
                if(fi.isFormField()){
                    processUploadField(fi, out); // 处理普通表单域
                }else{
                    processUploadFile(fi, out); // 处理上传文件
                }
            }
            out.close();
        }catch (Exception e){
            throw new ServletException(e);
        }
    }

    private void processUploadField(FileItem fi, PrintWriter out) {
        String name = fi.getFieldName();
        String value = fi.getString();
        out.println(name + ": " + value + "\r\n");
    }

    private void processUploadFile(FileItem fi, PrintWriter out) throws Exception {
        String filename = fi.getName();
        int index = filename.lastIndexOf("\\");
        filename = filename.substring(index + 1, filename.length()); //获取文件名
        long fileSize = fi.getSize();

        if("".equals(filename) && fileSize == 0){
            return;
        }

        File uploadedFile = new File(filePath + "/" + filename);
        fi.write(uploadedFile);
        out.println(filename + " is saved.");
        out.println("The size of" + filename + " is " + fileSize + "\r\n");
    }
}
