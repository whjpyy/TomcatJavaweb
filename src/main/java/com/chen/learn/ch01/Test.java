package com.chen.learn.ch01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-11-30.
 */
public class Test {

    public void sayHi(){
        System.out.println("Hi!");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*
        InputStream in = Test.class.getResourceAsStream("/index.jsp");
        byte[] bytes = new byte[3];
        int len;
        while( (len = in.read(bytes)) != -1 ){
            System.out.print(new String(bytes, 0, len));
        }*/

        Test obj = (Test)Class.forName("com.chen.learn.ch01.Test").newInstance();
        obj.sayHi();


        FileOutputStream fos = new FileOutputStream("target\\classes\\ch01\\a.txt");

        //1.cde 2.ac 3.bcfgh 4.b 5.acfg
        //6.ad 7.b 8.bc 9.bf 10.c

    }
}
