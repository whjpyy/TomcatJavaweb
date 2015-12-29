package com.chen.learn.ch09;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by YouZeng on 2015-12-28.
 */
public class MyData implements HttpSessionBindingListener, HttpSessionActivationListener{
    private int data;
    public MyData(){}
    public MyData(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("session: " + httpSessionEvent.getSession().getId() + " will be passivate..");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("session: " + httpSessionEvent.getSession().getId() + " is a activate.");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("MyData is bound with a session: " + httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("MyData is unbound with a session: " + httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public String toString() {
        return "MyData{" +
                "data=" + data +
                '}';
    }
}
