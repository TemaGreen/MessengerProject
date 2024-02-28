package com.example.messengerproject.component;

import com.example.messengerproject.data.model.User;

public class UserManager {

    private User currentUser;

    public User getUser() {
        return currentUser;
    }

    public void setUser(User user) {
        this.currentUser = user;
    }

    public void clear() {
        currentUser = new User();
    }

    public UserManager() {
    }
}
