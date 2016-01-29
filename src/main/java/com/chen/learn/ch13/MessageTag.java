package com.chen.learn.ch13;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Properties;

/**
 * Created by YouZeng on 2016-01-04.
 */
public class MessageTag extends TagSupport {
    private String key = null;

    @Override
    public int doStartTag() throws JspException {
        try{
            // 获得英文资源文本
            Properties ps = (Properties)pageContext.getAttribute("ps", pageContext.APPLICATION_SCOPE);
            // 获得英文资源文本
            Properties ps_ch = (Properties)pageContext.getAttribute("ps_ch", pageContext.APPLICATION_SCOPE);
            HttpSession session = pageContext.getSession();
            String language = (String)session.getAttribute("language");
            // 读取当前使用的语言
            String message = null;
            if(language != null && language.equals("Chinese")){
                message = (String)ps_ch.get(key);
                message = new String(message.getBytes("ISO-8859-1"), "UTF-8");
            }else{
                message = (String)ps.get(key);
            }
            // 打印静态文本
            pageContext.getOut().println(message);
        }catch (Exception e){
            throw new JspTagException(e);
        }
        return EVAL_PAGE;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
