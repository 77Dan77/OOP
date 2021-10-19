package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String message;

    @Override
    public String toString() {
        return name + " " + message;
    }

    public Person(String name, String message) {
        this.name = name;
        this.message = message;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
