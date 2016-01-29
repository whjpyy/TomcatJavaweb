package com.chen.learn.ch13;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by YouZeng on 2016-01-05.
 */
public class IterateTag extends TagSupport {

    private Iterator items; // 遍历的集合
    private String var; // 存放在页面范围内的集合的元素的属性名
    private Object item; // 集合中的一个元素

    public void setItems(Collection items) {
        if(items.size() > 0)
            this.items = items.iterator();
    }
    public void setVar(String var){
        this.var = var;
    }

    @Override
    public int doStartTag() throws JspException {
        if(items.hasNext()){
            item = items.next();
            saveItems(); // 把元素存放在页面范围内
            return EVAL_BODY_INCLUDE;
        }else{
            return SKIP_BODY;
        }
    }

    @Override
    public int doAfterBody() throws JspException {
        // 如果集合中还有元素，就把元素存放在页面范围内，再重复执行标签主体
        if(items.hasNext()){
            item = items.next();
            saveItems();
            return EVAL_BODY_AGAIN;
        }else{
            return SKIP_BODY;
        }
    }

    private void saveItems() {
        if(item == null){
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        }else{
            pageContext.setAttribute(var, item);
        }
    }
}
