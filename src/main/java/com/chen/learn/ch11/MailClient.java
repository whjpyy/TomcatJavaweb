package com.chen.learn.ch11;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by YouZeng on 2015-12-29.
 */
public class MailClient {
    protected Session session;
    protected Store store;
    private String sendHost = "smtp.sina.com"; // 发送邮件服务器
    private String receiveHost = "imap.sina.com"; // 接受邮件服务器
    private String sendProtocol = "smtp"; // 发送邮件协议
    private String reveiveProtocol = "imap"; // 接收邮件协议
    private String username = "whjpyy@sina.com";
    private String password = "13548179952";
    private String fromAddr = "whjpyy@sina.com"; // 发送者地址
    private String toAddr = "whjpyy@sina.com"; // 接受者地址

    public void init() throws Exception{
        // 设置JavaMail属性
        Properties properties = new Properties();
        properties.put("mail.smtp.host", sendHost);

        // 创建Session对象
        session = Session.getDefaultInstance(properties);

//        session.setDebug(true); // 输出跟踪日志
        // 创建Store对象
        store = session.getStore(reveiveProtocol);
        // 连接到接收邮件服务器
        store.connect(receiveHost, username, password);
    }

    public void close() throws Exception{
        store.close();
    }

    public void sendMessage(String fromAddr, String toAddr) throws Exception {
        // 创建一个邮件
        Message message = createSimpleMessage(fromAddr, toAddr);
        // 发送邮件
        /*Transport.send(message);*/
        Transport transport = session.getTransport();
        transport.connect(sendHost, username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    private Message createSimpleMessage(String fromAddr, String toAddr) throws Exception {
        // 创建一封纯文本类型的邮件
        Message message = new MimeMessage(session);
        InternetAddress[] toAddrs = InternetAddress.parse(toAddr, false);
        message.setRecipients(Message.RecipientType.TO, toAddrs);
        message.setSentDate(new Date());
        message.setSubject("Hello");
        message.setFrom(new InternetAddress(fromAddr));
        message.setText("通过Java程序发送邮件！");
        return message;
    }

    public static void main(String[] args) throws Exception {
        MailClient client = new MailClient();
        client.init();
//        client.sendMessage(client.fromAddr, client.toAddr);
        client.reveiveMessage();
        client.close();
    }

    public void reveiveMessage() throws Exception{
        browseMessagesFromFolder("test");
    }

    private void browseMessagesFromFolder(String folderName) throws Exception{
        Folder root = store.getDefaultFolder();
        Folder[] list = root.list("%");
        for(int i = 0;i < list.length;i ++){
            System.out.println(list[i].getName() + ", size:" + list[i].getMessageCount());
        }

        Folder folder = store.getFolder(folderName);
        if(folder == null){
            throw new Exception(folderName + "邮件夹不存在");
        }
        browseMessagesFromFolder(folder);
    }

    private void browseMessagesFromFolder(Folder folder) throws Exception{
        folder.open(Folder.READ_ONLY);
        System.out.println("You have " + folder.getMessageCount() + " messages in " + folder.getName());
        System.out.println("You have " + folder.getUnreadMessageCount() + " unread message in " + folder.getName());

        // 读邮件
        Message[] messages = folder.getMessages();
        for(int i = 1;i <= messages.length;i++){
            System.out.println("----------第" + i + "封邮件----------");
            // 打印邮件信息
            folder.getMessage(i).writeTo(System.out);
            System.out.println();
            System.out.println("标题：" + folder.getMessage(i).getSubject());
            System.out.println("内容：" + folder.getMessage(i).getContent());
        }
        // 关闭邮件夹，但不删除邮件夹中标记为"DELETED"的邮件
        folder.close(false);
    }
}
