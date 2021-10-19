package com.company;

import java.util.ArrayList;

public class SamsungApplication implements PhoneApplication{
    private String name;
    //private Contact allContacts[] = new Contact[500];
    ArrayList<Contact> allContacts = new ArrayList<>();
    private int contactSize = 0;


    public SamsungApplication(String name, int contactSize) {
        this.name = name;
        this.contactSize = contactSize;
}

    public SamsungApplication(){}

    @Override
    public void addContact(Contact c) {
        allContacts.add(c);
    }

    @Override
    public void printContacts() {
        System.out.println(getName());
        for (int i = 0; i < getContactSize(); i++){
            allContacts.get(i).printContactData();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getContactSize() {
        return contactSize;
    }

    public void setContactSize(int contactSize) {
        this.contactSize = contactSize;
    }
}
