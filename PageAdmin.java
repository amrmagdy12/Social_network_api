package com.company;

public class PageAdmin {
    User admin;
    PageController controller;
    public boolean makeUserAdminInPage(){
        return true;
    }

    public PageAdmin(User admin) {
        this.admin = admin;

    }

    public boolean removeAdminPrivelegesFromAdmin(){
        //write code here
        return true;
    }
}
