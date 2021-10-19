package com.company;

public abstract class Device extends Good{
    private String type;
    private String cpu;
    private int ram;

    public double basePerformance(){

        if (getCpu().equals("corei3")){
            return 1.3 * getRam();
        }
        else if (getCpu().equals("corei5")){
            return 1.7 * getRam();
        }
        else if (getCpu().equals("corei7")){
            return 2.1 * getRam();
        }
        else if (getCpu().equals("corei9")){
            return 2.5 * getRam();
        }

        else return getRam();
    }

    public abstract double getPerformance();

    public Device(){}

    public Device(String type, String cpu, int ram) {
        this.type = type;
        this.cpu = cpu;
        this.ram = ram;
    }

    public Device(double price, String model, int count, String type, String cpu, int ram) {
        super(price, model, count);
        this.type = type;
        this.cpu = cpu;
        this.ram = ram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
