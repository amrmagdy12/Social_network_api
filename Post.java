package com.company;

import java.util.ArrayList;

public class Post {
    String text;
    int numberOfLikes;
    int numberOfShares;
    User poster;
    ArrayList<User> likedByUsers = null;
    ArrayList<User> sharedByUsers = null;

    public Post(String text,User poster) {
        this.text = text;
        likedByUsers = new ArrayList<>();
        sharedByUsers = new ArrayList<>();
        this.numberOfLikes = 0;
        this.numberOfShares = 0;
        this.poster=poster;
    }

    public void incrementNumberOfLikes(User user) {
        likedByUsers.add(user);
        numberOfLikes++;
    }

    public void incrementNumberOfShares(User user) {
        sharedByUsers.add(user);
        numberOfShares++;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return poster.firstName+" "+poster.secondName+"\n"+text+"\n"+"likes: "+numberOfLikes+" shares: "+numberOfShares+"\n\n";
    }
}
