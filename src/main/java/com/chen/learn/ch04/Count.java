package com.chen.learn.ch04;

/**
 * Created by YouZeng on 2015-12-21.
 */
public class Count {
    private int count;

    public Count() {
        this(0);
    }

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(int step){
        this.count += step;
    }
}
