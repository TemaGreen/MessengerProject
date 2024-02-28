package com.example.messengerproject.data.model;

import com.example.messengerproject.data.item.ItemAddParticipant;

public class User {

    int id;

    String name;

    int icon;

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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public User(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public User(ItemAddParticipant item){
        this.id = item.getId();
        this.name = item.getName();
        this.icon = item.getIcon();
    }

    public User() {
    }
}
