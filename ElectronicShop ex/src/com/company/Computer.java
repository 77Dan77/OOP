package com.company;

public class Computer extends Device{
    private boolean ssd;
    private int memory;

    @Override
    public double getPerformance() {
        if (isSsd()){
            return basePerformance()*1.5;
        }
        else return basePerformance();

    }

    public Computer(boolean ssd, int memory) {
        this.ssd = ssd;
        this.memory = memory;
    }

    public Computer(String type, String cpu, int ram, boolean ssd, int memory) {
        super(type, cpu, ram);
        this.ssd = ssd;
        this.memory = memory;
    }

    public Computer(double price, String model, int count, String type, String cpu, int ram, boolean ssd, int memory) {
        super(price, model, count, type, cpu, ram);
        this.ssd = ssd;
        this.memory = memory;
    }

    @Override
    public String showDetails() {
        return getPrice() + " " + " " + getModel() + " " + getCount() + " " + getType() + " " + getCpu() + " " + getRam() + " " +
                " " + isSsd() + " " + getMemory();
    }

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
