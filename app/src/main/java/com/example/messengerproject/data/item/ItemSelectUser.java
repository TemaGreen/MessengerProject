package com.example.messengerproject.data.item;

public class ItemSelectUser {

    int id;

    String username;

    int icon;

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

    public ItemSelectUser(int id, String username, int icon) {
        this.id = id;
        this.username = username;
        this.icon = icon;
    }

    public ItemSelectUser() {
    }
}
