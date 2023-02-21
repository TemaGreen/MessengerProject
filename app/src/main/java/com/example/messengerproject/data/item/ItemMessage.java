package com.example.messengerproject.data.item;

public class ItemMessage {

    private int iconId;

    private int id_author;

    private int id_recipient;

    private String textMessage;

    private String timeMessage;

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getAuthor() {
        return id_author;
    }

    public void setAuthor(int id) {
        this.id_author = id;
    }

    public int getRecipient() {
        return id_recipient;
    }

    public void setRecipient(int id) {
        this.id_recipient = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String text_message) {
        this.textMessage = text_message;
    }

    public String getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(String timeMessage) {
        this.timeMessage = timeMessage;
    }

    public ItemMessage(int iconId, int id_author, int id_recipient, String text_message, String timeMessage) {
        this.iconId = iconId;
        this.id_author = id_author;
        this.id_recipient = id_recipient;
        this.textMessage = text_message;
        this.timeMessage = timeMessage;
    }

    public ItemMessage(int iconId, int id_author, int id_recipient, String text_message) {
        this.iconId = iconId;
        this.id_author = id_author;
        this.id_recipient = id_recipient;
        this.textMessage = text_message;
    }

    public ItemMessage(int id_author, int id_recipient, String text_message) {
        this.id_author = id_author;
        this.id_recipient = id_recipient;
        this.textMessage = text_message;
    }

    public ItemMessage() {

    }
}






















