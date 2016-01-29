package com.chen.learn.ch13;

/**
 * Created by YouZeng on 2016-01-05.
 */
public class BookDetails {
    private String name;
    private String title;
    private float price;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookDetails(String name, String title, float price, String description) {
        this.name = name;
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
