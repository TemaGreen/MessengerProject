package com.example.messengerproject.data.item;

public class ItemDialog {

    int id;

    String name;

    int author;

    String username;

    public String getNameDialog(){
        if (name.isEmpty()) {
            return "Диалог #";
        } else {
            return name;
        }
    }

    public String getAuthorDialog(){
        if (name.isEmpty()) {
            return "";
        } else {
            return username;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public ItemDialog(int id, String name, int author, String username) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.username = username;
    }

    public ItemDialog(int id, int author) {
        this.id = id;
        this.author = author;
    }

    public ItemDialog() {
    }
}
