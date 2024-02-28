package com.example.messengerproject.data.item;

import com.example.messengerproject.R;
import com.example.messengerproject.data.model.ResponseMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemMessage {

    private int id;

    private int id_author;

    private int icon;

    private String name;

    private String textMessage;

    private Date time;

    private static final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    static {
        map.put(1, R.drawable.ic_user_1);
        map.put(2, R.drawable.ic_user_2);
        map.put(3, R.drawable.ic_user_3);
        map.put(4, R.drawable.ic_user_4);
        map.put(5, R.drawable.ic_user_5);
        map.put(6, R.drawable.ic_user_6);
        map.put(7, R.drawable.ic_user_7);
        map.put(8, R.drawable.ic_user_8);
        map.put(9, R.drawable.ic_user_9);
        map.put(10, R.drawable.ic_user_10);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public int getIcon() {
        return map.get(icon);
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemMessage(int id, int id_author, int icon, String name, String textMessage, Date time) {
        this.id = id;
        this.id_author = id_author;
        this.icon = icon;
        this.name = name;
        this.textMessage = textMessage;
        this.time = time;
    }

    public ItemMessage(int id, int id_author, int icon, String name, String textMessage, long time) {
        this.id = id;
        this.id_author = id_author;
        this.icon = icon;
        this.name = name;
        this.textMessage = textMessage;
        this.time = new Date(time);
    }

    public ItemMessage(ResponseMessage responseMessage) {
        this.id = responseMessage.getId();
        this.id_author = responseMessage.getAuthor();
        this.icon = responseMessage.getIcon();
        this.name = responseMessage.getName();
        this.textMessage = responseMessage.getText();
        this.time = new Date(responseMessage.getTime());
    }
}






















