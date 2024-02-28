package com.example.messengerproject.data.model;

public class UserModel {

    int id;

    String name;

    int iconAvatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconAvatar() {
        return iconAvatar;
    }

    public void setIconAvatar(int iconAvatar) {
        this.iconAvatar = iconAvatar;
    }

    public UserModel(int id, String name, int iconAvatar) {
        this.id = id;
        this.name = name;
        this.iconAvatar = iconAvatar;
    }

    public UserModel(String name, int iconAvatar) {
        this.name = name;
        this.iconAvatar = iconAvatar;
    }

    public UserModel() {
    }
}
