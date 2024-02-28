package com.example.messengerproject.data.item;

import com.example.messengerproject.data.model.User;

public class ItemAddParticipant {

    int id;

    String name;

    int icon;

    boolean flag;

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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void flagToggle(){
        flag = !flag;
    }

    public ItemAddParticipant(User user, boolean flag) {
        this.id = user.getId();
        this.name = user.getName();
        this.icon = user.getIcon();
        this.flag = flag;
    }

    public ItemAddParticipant(int id, String name, int icon, boolean flag) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.flag = flag;
    }

    public ItemAddParticipant(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.icon = user.getIcon();
        this.flag = false;
    }

    public ItemAddParticipant(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.flag = false;
    }

    public ItemAddParticipant() {
    }
}
