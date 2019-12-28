package com.company;

import java.util.Date;


public class Message {
    User sender;
    User reciever;
    String text;
    Date date;

    public Message(User sender, User reciever, String text, Date date) {
        this.sender = sender;
        this.reciever = reciever;
        this.text = text;
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public User getReciever() {
        return reciever;
    }
}
