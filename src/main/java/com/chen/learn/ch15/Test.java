package com.chen.learn.ch15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YouZeng on 2016-01-29.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        System.out.println(list.size());
    }

    public static List<String> getColors(){
        List<String> list = new ArrayList<>();
        list.add("red1");
        list.add("red2");
        list.add("red3");
        list.add("red4");
        list.add("red5");
        return list;
    }
}
