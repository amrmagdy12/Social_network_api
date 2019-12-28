package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    private UserController userController;

    @Test
    @DisplayName("Test for Sending a normal friend request")
    void ShouldSendFriendRequestSuccessfull() {
        User firstUser = userController.storedObjects.storedUsers.get(0);
        User secondUser = userController.storedObjects.storedUsers.get(1);
        assertEquals(true, firstUser.addFriend(secondUser));
        assertEquals(1, secondUser.recievedNotifications.size(), "number of notifications is not 1");
    }

    @Test
    @DisplayName("Test for Sending a friend friend request")
    void ShouldNotSendFriendRequest() {
        User firstUser = userController.storedObjects.storedUsers.get(0);
        User secondUser = userController.storedObjects.storedUsers.get(1);
        firstUser.friends.add(secondUser);
        assertEquals(false, firstUser.addFriend(secondUser), "user just sended a friend a friend request XD");
        assertEquals(0, secondUser.recievedNotifications.size(), "user just added a friend who was a friend!!!");
    }

    @Test
    @DisplayName("Test for normal friend request recieved")
    void ShouldRespondToFriendRequestSuccesfully() {
        User user = userController.storedObjects.storedUsers.get(3);
        Notification notification = user.getFirstNotification();
        assertNotNull(user.getFirstNotification(), "there was no notifications to begin with");
        assertEquals(0, notification.requesterUser.friends.size(), "number of friends did not start at 0");
        assertNotEquals(false, user.acceptFriendRequest(notification), "not working");
        assertEquals(1, user.friends.size(), "number of friends did change at the reciever user");
        assertEquals(1, notification.requesterUser.friends.size(), "number of friends did not change at the sender");
    }

    @Test
    @DisplayName("Test for a null notification")
    void ShouldNotRespondToNullNotification() {
        User user = userController.storedObjects.storedUsers.get(3);
        Notification notification=null;
        assertEquals(false, user.acceptFriendRequest(notification), "just accepted a null notification");
        assertEquals(0, user.friends.size(), "number of friends did change at the reciever user");
    }



    @BeforeEach
    private void intialize() {
        userController = new UserController();
    }
}