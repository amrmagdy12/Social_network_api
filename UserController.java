package com.company;

import java.util.*;

public class UserController {
    public  StoredUserObjects storedObjects;
    private  UserController userController=null;
    ArrayList<String> availablePaymentMethods;



    public UserController() {
        storedObjects =new StoredUserObjects(this);
        availablePaymentMethods = new ArrayList<>();
        availablePaymentMethods.add("credit card");
        availablePaymentMethods.add("paypal");
    }

    public User login(String email, String password) {
        User userAccount = storedObjects.getUserAccount(email, password);
        return userAccount;
    }

    public void logOut() {

    }

    public void updateProfile() {

    }

    public User createAccount(String email, String firstName, String secondName, String password
            , String gender, String paymentType, String cardNumber, String zipcode, String cardholdername
            , String securityNumber, String address, Date expirationDate) {
        User newUser = null;
        if (storedObjects.getUserAccount(email, password) != null) {
            return newUser;
        }

        Payment paymentMethod = new Payment(cardNumber, cardholdername, securityNumber, expirationDate, zipcode, address);
        newUser = new User(paymentMethod, firstName, secondName, email, gender, password,this);
        updateStoredData(newUser);
        return newUser;

    }

    public User createAccount(String email, String firstName, String secondName, String password
            , String gender, String paymentType, String PayPal_email, String PayPal_password) {
        User newUser = null;
        if (storedObjects.getUserAccount(email, password) != null) {
            return newUser;
        }

        Payment paymentMethod = new Payment(PayPal_email, PayPal_password);
        newUser = new User(paymentMethod, firstName, secondName, email, gender, password,this);
        updateStoredData(newUser);
        return newUser;
    }

    private void updateStoredData(User newUser) {
        storedObjects.addNewUser(newUser);
        storedObjects.indexes.add(0);
    }

    public void sendNotification(User firstUser, User secondUser) {
        storedObjects.storedUsers.get(storedObjects.storedUsers.indexOf(secondUser))
                .addNotification(new Notification(firstUser));

    }

    public void showUserPosts(User user) {
        for (Post writtenPost : user.writtenPosts) {
            System.out.println(writtenPost);
        }
    }

}
