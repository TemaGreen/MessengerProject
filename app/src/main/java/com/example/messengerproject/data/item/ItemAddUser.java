package com.example.messengerproject.data.item;

public class ItemAddUser {

    int id;

    String name;

    int icon;

    boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void toggle(){
        this.selected = !this.selected;
    }

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

    public ItemAddUser(int id, String name, int icon, boolean selected) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.selected = selected;
    }

    public ItemAddUser(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.selected = false;
    }

    public ItemAddUser() {
    }
}
