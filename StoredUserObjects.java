package com.company;

import java.util.ArrayList;

public class StoredUserObjects {
    UserController belongedToController;
    public  ArrayList<Integer> indexes;
    public  ArrayList<User> storedUsers;
     StoredUserObjects storedUserObjects;

    public StoredUserObjects(UserController belongedToController) {
        this.belongedToController=belongedToController;
        storedUsers = new ArrayList<>(4);
        indexes = new ArrayList<>();
        storedUsers.add(new User(null, "kareem", "magdy"
                , "kareemmagdy1@yahoo.com", "male", "shlafi",belongedToController));
        storedUsers.get(0).writtenPosts.add(new Post(": my first post",storedUsers.get(0)));
        indexes.add(0);
        storedUsers.add(new User(null, "amr", "magdy"
                , "amrmagdy1@yahoo.com", "male", "shlafi",belongedToController));
        storedUsers.get(1).writtenPosts.add(new Post(": my first post",storedUsers.get(1)));
        indexes.add(0);
        storedUsers.add(new User(null, "mark", "samuel"
                , "marksamuel1@yahoo.com", "male", "shlafi",belongedToController));
        storedUsers.get(2).writtenPosts.add(new Post(": my first post",storedUsers.get(2)));
        indexes.add(0);
        storedUsers.add(new User(null, "youssef", "3okasha"
                , "3okasha@yahoo.com", "male", "shlafi",belongedToController));
        storedUsers.get(3).writtenPosts.add(new Post(": my first post",storedUsers.get(3)));
        indexes.add(0);
        storedUsers.get(3).recievedNotifications.add(new Notification(storedUsers.get(0)));
    }
    public User getUserAccount(String email, String password) {
        User user;
        for (int index = 0; index < storedUsers.size(); index++) {
            if (storedUsers.get(index).email.equals(email) && (storedUsers.get(index).password.equals(password))) {
                if (indexes.get(index) == 0) {
                    indexes.set(index, 1);
                    return storedUsers.get(index);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public boolean checkIfUserExists(String email) {
        for (User storedUser : storedUsers) {
            if (storedUser.email.equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void addNewUser(User newUser) {
        storedUsers.add(newUser);
    }

    public ArrayList<User> searchForUser(String name, User user) {
        ArrayList<User> matchingUsers = new ArrayList<>();
        for (User storedUser : storedUsers) {
            if ((storedUser.firstName.equalsIgnoreCase(name)) || (storedUser.secondName.equalsIgnoreCase(name))
                    && (storedUser != user) && (!user.friends.contains(storedUser))) {
                matchingUsers.add(storedUser);
            }
        }
        return matchingUsers;
    }


}
