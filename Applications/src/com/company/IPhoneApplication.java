package com.company;

import java.util.ArrayList;

public class IPhoneApplication implements PhoneApplication{
    private String name;
   // private Contact allContacts[] = new Contact[1000];
    ArrayList<Contact> allContacts = new ArrayList<>();
    private int contactSize = 0;


public IPhoneApplication(String name, int contactSize) {
    this.name = name;
    this.contactSize = contactSize;
}

    public IPhoneApplication(){}

    @Override
    public void addContact(Contact c) {
        allContacts.add(c);
    }

    @Override
    public void printContacts() {
            System.out.println(getName());
            for (int i = 0; i < getContactSize(); i++){
                System.out.print((i+1) + " contact:  ");
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
