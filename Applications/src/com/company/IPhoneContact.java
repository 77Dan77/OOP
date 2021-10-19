package com.company;

public class IPhoneContact extends Contact{
    private int id;
    private String name;
    private String surname;
    private String firstPhone;
    private String secondPhone;
    private String thirdPhone;

    ////////////////////////const////////////////////////////

    public IPhoneContact(int id, String name, String surname, String firstPhone, String secondPhone, String thirdPhone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.firstPhone = firstPhone;
        this.secondPhone = secondPhone;
        this.thirdPhone = thirdPhone;
    }

    public IPhoneContact(){

    }

    @Override
    public String getPersonalData() {
        return getId() + " " + getName() + " " + getSurname();
    }

    @Override
    public String getPhone() {
        return getFirstPhone() + "\t " + getSecondPhone() + "\t " + getThirdPhone();
    }

    @Override
    public void printContactData() {
        System.out.println( getPersonalData() + "    "  + getPhone());
    }

    /////////////////////////GET SET//////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstPhone() {
        return firstPhone;
    }

    public void setFirstPhone(String firstPhone) {
        this.firstPhone = firstPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public String getThirdPhone() {
        return thirdPhone;
    }

    public void setThirdPhone(String thirdPhone) {
        this.thirdPhone = thirdPhone;
    }
}
