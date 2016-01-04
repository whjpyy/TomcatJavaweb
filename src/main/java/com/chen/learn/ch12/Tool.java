package com.chen.learn.ch12;

import java.io.UnsupportedEncodingException;

/**
 * Created by YouZeng on 2016-01-04.
 */
public class Tool {

    public static int add(String x, String y){
        int a = 0;
        int b = 0;
        try{
            a = Integer.parseInt(x);
            b = Integer.parseInt(y);
        }catch (Exception e){
        }
        return a + b;
    }

    public static String convert(String s, String encode1, String encode2){
        try {
            return new String(s.getBytes(encode1), encode2);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
