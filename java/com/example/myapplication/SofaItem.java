package com.example.myapplication;

public class SofaItem {
    private String name;
    private String price;
    private double rating;
    private int imageResId;

    public SofaItem(String name, String price, double rating, int imageResId) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getImageResId() {
        return imageResId;
    }
}