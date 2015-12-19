package com.chen.learn.ch03;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-12-18.
 */
public class HelloTag extends TagSupport{
    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("Hello");
        } catch (IOException e) {
            new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}
