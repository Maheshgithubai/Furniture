package com.example.myapplication;

public class CartItem {
    private String name;
    private String price;
    private int quantity;
    private int imageResourceId;

    public CartItem(String name, String price, int quantity, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}