package com.company;



/*
 * this
 * class is done
 *
 *
 *
 *
 *
 *
 *
 * */

public class GroupAdmin {
    User admin;
    Group group;
    GroupController controller=null;

    public GroupAdmin(User admin, Group group,GroupController controller) {
        this.admin = admin;
        this.group = group;
        this.controller=controller;
    }

    public boolean respondToJoinRequest(){
        //write code here
        return true;
    }

    public boolean removeMemberFromGroup(){
        //write code here
        return true;
    }
    public boolean makeMemberGroupAdmin(){
        //write code here
        return true;
    }
    public  boolean removeAdminPrivelegesFromAdmin(){
        //write code here
        return true;
    }
}
