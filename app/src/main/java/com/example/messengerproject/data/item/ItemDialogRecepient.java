package com.example.messengerproject.data.item;

import com.example.messengerproject.data.model.User;

public class ItemDialogRecepient {

    int id;

    String username;

    int icon;

    Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public ItemDialogRecepient(User user) {
        this.id = user.getId();
        this.username = user.getName();
        this.icon = user.getIcon();
        this.role = Role.Default;
    }

    public ItemDialogRecepient(User user, Role role) {
        this.id = user.getId();
        this.username = user.getName();
        this.icon = user.getIcon();
        this.role = role;
    }

    public ItemDialogRecepient(int id, String username, int icon) {
        this.id = id;
        this.username = username;
        this.icon = icon;
        this.role = Role.Default;
    }

    public ItemDialogRecepient(int id, String username, int icon, Role role) {
        this.id = id;
        this.username = username;
        this.icon = icon;
        this.role = role;
    }

    public ItemDialogRecepient() {
    }
}

enum Role {
    Creater,
    Admin,
    User,
    Default;
}
