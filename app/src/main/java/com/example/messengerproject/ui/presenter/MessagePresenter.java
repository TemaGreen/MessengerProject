package com.example.messengerproject.ui.presenter;

import android.annotation.SuppressLint;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.MessageManager;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.adapter.MessageAdapter;
import com.example.messengerproject.data.item.ItemMessage;
import com.example.messengerproject.data.model.ResponseMessage;
import com.example.messengerproject.ui.interfaces.IMessageBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class MessagePresenter implements IMessageBase.IPresenter {

    private IMessageBase.IView view;

    private List<ItemMessage> list;

    private MessageAdapter adapter;

    @Inject
    DataManager dataManager;

    @Inject
    UserManager userManager;

    @Inject
    MessageManager messageManager;

    private int dialog_id;

    private int user;

    @Override
    public void attachView(IMessageBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        initComponents();
        this.view.initView();
        initAdapter();
    }

    private void initComponents() {
        dialog_id = view.getIntent().getIntExtra("id_dialog", 0);
        user = userManager.getUser().getId();
    }

    @SuppressLint("CheckResult")
    private void initAdapter() {
        dataManager.getDialogMessages(dialog_id)
                .doOnSubscribe(disposable -> {
                    list = new LinkedList<>();
                })
                .subscribe(response -> {
                    List<ResponseMessage> messages = new Gson().fromJson(response.body(), new TypeToken<List<ResponseMessage>>() {
                    }.getType());
                    list = messages.stream().map(responseMessage -> new ItemMessage(responseMessage)).collect(Collectors.toList());
                    adapter = new MessageAdapter(list, this, new SimpleDateFormat("HH:mm"), user);
                    this.view.setAdapter(adapter);
                }, throwable -> throwable.printStackTrace());
    }


    @Override
    @SuppressLint("CheckResult")
    public void clickButtonSendMessage() {
        String message = view.getTextMessage();
        dataManager.sendMessage(dialog_id, userManager.getUser().getId(), message)
                .subscribe(response ->{
                    ResponseMessage responseMessage = new Gson().fromJson(response.body(), ResponseMessage.class);
                    list.add(new ItemMessage(responseMessage));
                    adapter.notifyDataSetChanged();
        }, throwable -> { throwable.printStackTrace();});
    }

    

    @Inject
    public MessagePresenter() {
    }
}
