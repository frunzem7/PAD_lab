package com.example.pad_lab.lab_no_2;

public class PubSubExample {
    public static void main(String[] args) {
        Channel channel = new Channel();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.publish("Hello, this is a test message!");
    }
}
