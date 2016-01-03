package com.chen.learn.ch11;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 通过Javamail发送一个简单的邮件
 */
public class Sendmail {

    private static String sendHost = "smtp.sina.com"; // 发送邮件服务器
    private static String sendProtocol = "smtp"; // 发送邮件协议
    private static String auth = "true"; // 开启验证
    private static String username = "whjpyy@sina.com"; // 邮箱用户
    private static String password = "13548179952"; // 邮箱密码
    private static String toAddr = "409121961@qq.com"; // 接收者地址

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host", sendHost);
        prop.setProperty("mail.transport.protocol", sendProtocol);
        prop.setProperty("mail.smtp.auth", auth);
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(sendHost, username, password);
        //4、创建文本邮件
//        Message message = createSimpleMail(session);
        // 创建带图片的文本邮件
//        Message message = createImageMail(session);
        // 创建带有附件的文本邮件
        Message message = createAttachMail(session);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(username));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(username));
        //邮件的标题
        message.setSubject("只包含文本的简单邮件");
        //邮件的文本内容
        message.setContent("你好啊！", "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

    /**
     * 创建一个包含图片的邮件
     * @param session
     * @return
     */
    public static MimeMessage createImageMail(Session session) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        // 收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(username));
        message.setSubject("带图片的邮件");

        // 准备邮件数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:xxx.jpg'>的邮件", "text/html;charset=utf-8");
        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("target\\classes\\ch11\\1.png"));
        image.setDataHandler(dh);
        image.setContentID("xxx.jpg");
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        message.setContent(mm);
        message.saveChanges();
        // 将创建好的邮件写入E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("target\\classes\\ch11\\ImageMail.eml"));
        return message;
    }

    public static MimeMessage createAttachMail(Session session) throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(username));
        message.setSubject("JavaMail邮件发送测试");

        // 创建邮件正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=utf-8");

        // 创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("target\\classes\\ch11\\1.png"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());

        // 创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");

        message.setContent(mp);
        message.saveChanges();
        message.writeTo(new FileOutputStream("target\\classes\\ch11\\attachMail.eml"));
        return message;
    }

}
