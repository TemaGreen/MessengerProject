package com.example.messengerproject.ui.presenter;

import android.annotation.SuppressLint;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.adapter.SelectUserAdapter;
import com.example.messengerproject.data.item.ItemSelectUser;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.interfaces.ISelectUsersBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class SelectUsersPresenter implements ISelectUsersBase.IPresenter {

    @Inject
    DataManager dataManager;

    @Inject
    UserManager userManager;

    private ISelectUsersBase.IView view;

    private LinkedList<User> users;

    private SelectUserAdapter adapter;

    @Override
    public void attachView(ISelectUsersBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        initAdapter();
        this.view.initView();
    }

    @SuppressLint("CheckResult")
    private void initAdapter() {
        dataManager.getUsers().subscribe(response -> {
            users = new Gson().fromJson(response.body(), new TypeToken<LinkedList<User>>() {}.getType());
            List<ItemSelectUser> list = users.stream()
                    .map(user -> new ItemSelectUser(
                            user.getId(),
                            user.getName(),
                            user.getIcon()
                    ))
                    .collect(Collectors.toList());
            adapter = new SelectUserAdapter(list, this);
            this.view.setAdapter(adapter);
        }, throwable -> throwable.printStackTrace());
    }

    @Override
    public void clickButtonNewUser() {

    }

    

    @Inject
    public SelectUsersPresenter() {
    }
}
