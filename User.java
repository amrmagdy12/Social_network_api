package com.company;

import java.awt.*;
import java.util.*;

public class User {
    private  final double UPGRADE_INTO_PREMIUM_AMMOUNT = 99.9;
    private  final int DONE_NUMBER = 1;
    String[] normalUserFunctions = {};
    String[] premiumUserFunctions = {};
    private UserController userController;
    Payment paymentMethod;
    String firstName;
    String secondName;
    String email;
    String gender;
    String password;//add in class diagram
    Image profilePicture;
    Page personalPage;
    MessageBoard messageBoard;
    private int CANCELATION_NUMBER = -1;
    ArrayList<Group> joinedGroups;
    ArrayList<Post> writtenPosts;
    ArrayList<User> friends;
    ArrayList<Notification> recievedNotifications;
    boolean isPremiumUser;
    int numberOfAdsLeft = 0;

    public Notification getFirstNotification() {
        if (recievedNotifications.size() != 0) {
            return recievedNotifications.get(0);
        }
        return null;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName;
    }

    public User(Payment paymentMethod, String firstName, String secondName, String email, String gender
            , String password,UserController userController) {
        this.paymentMethod = paymentMethod;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        joinedGroups = new ArrayList<>();
        writtenPosts = new ArrayList<>();
        recievedNotifications = new ArrayList<>();
        messageBoard = new MessageBoard();
        this.userController = userController;
        friends = new ArrayList<>();
    }

    public boolean upgradeToPremium() {
        if (paymentMethod == null) {
            return false;
        }
        if (paymentMethod.payForService(UPGRADE_INTO_PREMIUM_AMMOUNT)) {
            isPremiumUser = true;
            return true;
        }
        return false;
    }

    public String[] getAvailableFunctions() {
        if (isPremiumUser) {
            return premiumUserFunctions;
        }
        return normalUserFunctions;
    }

    public void addGroup(Group group) {
        joinedGroups.add(group);
    }

    public ArrayList<Notification> getFriendRequests() {
        ArrayList<Notification> notifications = new ArrayList<>();
        for (Notification recievedNotification : recievedNotifications) {
            if (recievedNotification.type.equalsIgnoreCase("user notification")) {
                notifications.add(recievedNotification);
            }
        }
        return notifications;
    }

    public ArrayList<Notification> getPostRequests() {
        ArrayList<Notification> notifications = new ArrayList<>();
        for (Notification recievedNotification : recievedNotifications) {
            if (recievedNotification.type.equalsIgnoreCase("Post notification")) {
                notifications.add(recievedNotification);
            }
        }
        return notifications;
    }

    public ArrayList<Notification> getMessageRequests() {
        ArrayList<Notification> notifications = new ArrayList<>();
        for (Notification recievedNotification : recievedNotifications) {
            if (recievedNotification.type.equalsIgnoreCase("message notification")) {
                notifications.add(recievedNotification);
            }
        }
        return notifications;
    }

    public void writeAd() {
        //write code here
        numberOfAdsLeft--;
    }

    public boolean buyMoreAds() {
        //write code here
        return true;
    }

    public ArrayList<Notification> getRecievedNotifications() {
        return recievedNotifications;
    }

    public boolean acceptFriendRequest(Notification notification) {
        if ((notification == null) || (!notification.type.equals(Notification.USER_NOTIFICATION))) {
            return false;
        }
        friends.add(notification.requesterUser);
        notification.requesterUser.friends.add(this);
        recievedNotifications.remove(notification);
        return true;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean addFriend(User user) {
        ArrayList<User> storedUsers = userController.storedObjects.storedUsers;
        if (friends.contains(user)) {
            return false;
        } else if (!userController.storedObjects.storedUsers.contains(user)) {
            return false;
        } else {
            for (Notification recievedNotification : storedUsers.get(storedUsers.indexOf(user)).recievedNotifications) {
                if (recievedNotification.requesterUser == this) {
                    return false;
                }
            }
            userController.sendNotification(this, storedUsers.get(storedUsers.indexOf(user)));
            return true;
        }
    }


    public void sendMessage() {

    }

    public String[] getUserInfo() {
        String[] info = {firstName, secondName, email, gender, password};
        //write code here
        return info;
    }


    public void post(String text) {

    }

    public void likePost(Post post) {

    }

    public void sharePost(Post post) {

    }

    public void likePage(Page likedPage) {

    }

    public void joinGroup(Group group) {

    }

    public void createGroup() {

    }

    public void createPage() {

    }

    public void addNotification(Notification notification) {
        recievedNotifications.add(notification);
    }

    public ArrayList<User> searchForUsers(String name) {
        return userController.storedObjects.searchForUser(name, this);

    }

    //    public void respondToFriendRequests() {
//            ArrayList<Notification> friendRequests = getFriendRequests();
//        while (true) {
//            if(friendRequests.size()==0) {
//                System.out.println("no new friend requests recieved");
//                break;
//            }
//            for (int index = 0; index < friendRequests.size(); index++) {
//                System.out.println(index + 1 + "- " + friendRequests.get(index).requesterUser.firstName + " "
//                        + friendRequests.get(index).requesterUser.firstName);
//            }
//            int choice = -1;
//            System.out.println("enter the number of the user you want to respond to");
//            choice = userController.scanner.nextInt();
//            choice--;
//            if (choice < friendRequests.size()) {
//                int userIndex = choice;
//                System.out.println("what do you want to do:");
//                System.out.println("1-accept friend request");
//                System.out.println("2-decline friend request");
//                System.out.print("choice: ");
//                choice = userController.scanner.nextInt();
//                if (choice == 1) {
//                    addFriend(friendRequests.get(userIndex).requesterUser);
//                    friendRequests.get(userIndex).requesterUser.addFriend(this);
//                    friendRequests.remove(userIndex);
//                } else if (choice == 2) {
//                    friendRequests.remove(friendRequests.get(userIndex));
//                }
//            } else {
//                System.out.println("wrong input exiting now");
//                break;
//            }
//        }
//        for (User friend : friends) {
//            System.out.println(friend.firstName);
//        }
//    }
}

