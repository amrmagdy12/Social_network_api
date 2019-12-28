package com.company;

import java.util.ArrayList;



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

public class Group {
    String name;
    boolean isPrivate;
    ArrayList<User>members;
    ArrayList<GroupAdmin>admins;
    GroupController groupController;

    public Group(String name, boolean isPrivate) {
        this.name = name;
        this.isPrivate = isPrivate;
    }

    public void makeMember(User user){

    }

    public void makeAdmin(User member){

    }
}
