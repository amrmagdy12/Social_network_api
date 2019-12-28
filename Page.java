package com.company;

import java.util.ArrayList;

public class Page {
    String name;
    int numberOfLikes;
    ArrayList<Post> pagePosts;
    ArrayList<PageAdmin> admins;


    public Page(String name,User user) {
        this.name = name;
        numberOfLikes=0;
        pagePosts = new ArrayList<>();
        admins = new ArrayList<>();
        admins.add(new PageAdmin(user));
    }

    public void addPost(Post post){

    }

    public void addAdmin(User user){

    }



}
