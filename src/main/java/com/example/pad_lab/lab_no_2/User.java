package com.example.pad_lab.lab_no_2;

public class User implements Subscriber {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
