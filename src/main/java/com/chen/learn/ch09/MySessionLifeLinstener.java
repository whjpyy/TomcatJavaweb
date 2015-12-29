package com.chen.learn.ch09;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by YouZeng on 2015-12-28.
 */
public class MySessionLifeLinstener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Attribute[" + event.getName() + "=" + event.getValue() + "]" +
                " is added into session: " + event.getSession().getId());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Attribute[" + event.getName() + "=" + event.getValue() + "]" +
                " is removed into session: " + event.getSession().getId());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribute[" + event.getName() + "=" + event.getValue() + "]" +
                " is replaced into session: " + event.getSession().getId());
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session: " + httpSessionEvent.getSession().getId() + " is created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session: " + httpSessionEvent.getSession().getId() + " is destroyed.");
    }
}
