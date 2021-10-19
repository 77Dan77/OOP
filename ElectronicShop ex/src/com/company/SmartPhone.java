package com.company;

public class SmartPhone extends Device{
    private double mgpx;
    private int generation;


    public double getPerformance() {
        return basePerformance()+generation*mgpx ;
    }

    @Override
    public String showDetails() {
        return getPrice() + " " + " " + getModel() + " " + getCount() + " "
                + getType() + " " + getCpu() + " " + getRam() + " " +
                " " + getMgpx() + " " + getGeneration();
    }

    public SmartPhone(double mgpx, int generation) {
        this.mgpx = mgpx;
        this.generation = generation;
    }

    public SmartPhone(String type, String cpu, int ram, double mgpx, int generation) {
        super(type, cpu, ram);
        this.mgpx = mgpx;
        this.generation = generation;
    }

    public SmartPhone(double price, String model, int count, String type, String cpu, int ram, double mgpx, int generation) {
        super(price, model, count, type, cpu, ram);
        this.mgpx = mgpx;
        this.generation = generation;
    }

    public double getMgpx() {
        return mgpx;
    }

    public void setMgpx(double mgpx) {
        this.mgpx = mgpx;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
