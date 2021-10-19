package com.company;

public class GoodItem {
    private String name;
    private int price;

    public GoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public GoodItem(){}


    @Override
    public String toString() {
        return name + " " + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
