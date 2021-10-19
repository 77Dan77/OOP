package com.company;

public class Tablet extends Device {
    private double weight;
    private boolean touch;

    @Override
    public double getPerformance() {
        return basePerformance();
    }

    public Tablet(double weight, boolean touch) {
        this.weight = weight;
        this.touch = touch;
    }

    public Tablet(String type, String cpu, int ram, double weight, boolean touch) {
        super(type, cpu, ram);
        this.weight = weight;
        this.touch = touch;
    }

    public Tablet(double price, String model, int count, String type, String cpu, int ram, double weight, boolean touch) {
        super(price, model, count, type, cpu, ram);
        this.weight = weight;
        this.touch = touch;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String showDetails() {
        return getPrice() + " " + " " + getModel() + " " + getCount() + " " + getType() + " " + getCpu() + " " + getRam() + " " + getWeight() + " " + isTouch();
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }
}
