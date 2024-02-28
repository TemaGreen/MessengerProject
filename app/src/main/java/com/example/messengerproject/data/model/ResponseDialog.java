package com.example.messengerproject.data.model;

public class ResponseDialog {

    int id;

    String name;

    int author;

    String username;

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

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ResponseDialog(int id, String name, int author, String username) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.username = username;
    }

    public ResponseDialog() {
    }
}
