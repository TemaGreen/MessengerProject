package com.example.messengerproject.data.model;

import java.util.List;

public class RequestCreateDialog {

    int author;

    String name;

    List<Integer> users;

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public RequestCreateDialog(int author, String name, List<Integer> users) {
        this.author = author;
        this.name = name;
        this.users = users;
    }

    public RequestCreateDialog() {
    }
}
