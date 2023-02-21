package com.example.messengerproject.ui.presenter;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.MessageManager;
import com.example.messengerproject.data.adapter.MessageAdapter;
import com.example.messengerproject.data.item.ItemMessage;
import com.example.messengerproject.ui.interfaces.IMessageBase;

import java.util.List;

import javax.inject.Inject;

public class MessagePresenter implements IMessageBase.IPresenter {

    IMessageBase.IView view;

    List<ItemMessage> list;

    MessageAdapter adapter;

    @Inject
    DataManager dataManager;

    @Inject
    MessageManager messageManager;

    @Override
    public void attachView(IMessageBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        this.view.initView();
        initAdapter();
    }

    private void initAdapter(){
        list = dataManager.getList();
        adapter = new MessageAdapter(list, this);
        this.view.setAdapter(adapter);
    }

    @Override
    public void clickButtonSendMessage() {
        String message = view.getEnterTextMessage();
        this.view.clearTextViewForEnterMessage();
        messageManager.send(message);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Inject
    public MessagePresenter() {
    }
}
