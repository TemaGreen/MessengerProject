package com.example.messengerproject.ui.presenter;

import android.content.Intent;

import com.example.messengerproject.component.App;
import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.activity.DialogsActivity;
import com.example.messengerproject.ui.activity.EditDialogActivity;
import com.example.messengerproject.ui.activity.MainActivity;
import com.example.messengerproject.ui.activity.MessageActivity;
import com.example.messengerproject.ui.activity.SelectUsersActivity;
import com.example.messengerproject.ui.interfaces.IMainBase;
import com.example.messengerproject.ui.interfaces.ISelectUsersBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;

import javax.inject.Inject;

public class MainPresenter implements IMainBase.IPresenter{

    IMainBase.IView view;

    @Inject
    DataManager dataManager;

    @Inject
    UserManager userManager;

    public void attachView(MainActivity view) {
        this.view = view;
    }

    public void viewIsReady() {
        this.view.initView();
    }

    public void clickButtonSelectUserFirst() {
        dataManager.getUserById(1).subscribe(response -> {
            User user = new Gson().fromJson(response.body(), User.class);
            userManager.setUser(user);
            Intent intent = new Intent(view.getContext(), DialogsActivity.class);
            this.view.openPage(intent);
        }, throwable -> throwable.printStackTrace());
    }

    public void clickButtonSelectUser() {
        this.view.openPage(new Intent(this.view.getContext(), EditDialogActivity.class));
    }

    public void clickButtonNewUser() {
        //экран создания нового пользователя
    }

    @Override
    public void attachView(IMainBase.IView view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    @Inject
    public MainPresenter() {
    }
}
/*
dataManager.getUser("User1").subscribe(response -> {
            User user = new Gson().fromJson(response.body(), User.class);
            userManager.setUser(user);
        }, throwable -> {

        });
 */