package com.company;

import java.util.ArrayList;


public class Notification {
    private final static String POST_NOTIFICATION = "post notification";
    private final static String MESSAGE_NOTIFICATION = "mesage notification";
    public final static String USER_NOTIFICATION = "user notification";
    public boolean isUnseen;
    String type;
    User requesterUser;
    Post post;
    Message message;


    public Notification(User requesterUser, Message message) {
        this.type = MESSAGE_NOTIFICATION;
        this.requesterUser = requesterUser;
        this.message = message;
        isUnseen = true;
    }

    public Notification(User requesterUser, Post post) {
        this.type = POST_NOTIFICATION;
        this.requesterUser = requesterUser;
        this.post = post;
        isUnseen = true;
    }

    public Notification(User requesterUser) {

        this.type = USER_NOTIFICATION;
        this.requesterUser = requesterUser;
        isUnseen = true;
    }

}
