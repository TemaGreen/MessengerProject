package com.example.messengerproject.component;

import com.example.messengerproject.R;
import com.example.messengerproject.data.item.ItemMessage;

import java.util.LinkedList;

public class DataManager {

    LinkedList<ItemMessage> list;

    public DataManager() {
        list = new LinkedList<>();
        fillingData();
    }

    public DataManager(LinkedList<ItemMessage> list) {
        this.list = list;
    }

    public LinkedList<ItemMessage> getList() {
        return list;
    }

    private void fillingData(){
        this.list.add(new ItemMessage(R.drawable.ic_user_1,1, 2, "Привет, Мир"));
        this.list.add(new ItemMessage(R.drawable.ic_user_2,2, 1, "Привет"));
        this.list.add(new ItemMessage(R.drawable.ic_user_1,1, 2, "Как дела?"));
        this.list.add(new ItemMessage(R.drawable.ic_user_2,2, 1, "Очень много чего произошло, Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень Очень много"));
    }
}
