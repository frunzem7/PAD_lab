package com.example.pad_lab.lab_no_2;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}
