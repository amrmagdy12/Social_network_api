package com.company;

import java.util.ArrayList;

public class MessageBoard {
    ArrayList<Message> messages;

    public MessageBoard() {
        messages = new ArrayList<>();
    }

    public void addMsg(Message message) {
        messages.add(message);
    }

    public boolean createMessage(User friend) {
        return true;
    }

    public void sendMessage(Message message) {

    }
}
