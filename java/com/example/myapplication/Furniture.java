package com.example.myapplication;

public class Furniture {
    private String name;
    private String price;
    private String rating;
    private int imageResourceId;

    public Furniture(String name, String price, String rating, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
