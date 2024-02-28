package com.example.messengerproject.ui.presenter;

import android.annotation.SuppressLint;
import android.content.Intent;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.adapter.DialogAdapter;
import com.example.messengerproject.data.adapter.MessageAdapter;
import com.example.messengerproject.data.item.ItemDialog;
import com.example.messengerproject.data.model.ResponseDialog;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.activity.CreateNewDialogActivity;
import com.example.messengerproject.ui.activity.EditDialogActivity;
import com.example.messengerproject.ui.activity.MessageActivity;
import com.example.messengerproject.ui.interfaces.IDialogsBase;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.functions.Function;

public class DialogsPresenter implements IDialogsBase.IPresenter {

    IDialogsBase.IView view;

    private LinkedList<ItemDialog> list;

    private DialogAdapter adapter;

    @Inject
    DataManager dataManager;

    @Inject
    UserManager userManager;

    @Override
    public void attachView(IDialogsBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        initAdapter();
        view.initView();
    }

    @SuppressLint("CheckResult")
    private void initAdapter() {
        User user = userManager.getUser();
        dataManager.getDialogsByUserId(user.getId())
                .doOnSubscribe(disposable -> list = new LinkedList<>())
                .subscribe(response -> {
                    List<ResponseDialog> dialogs = new Gson().fromJson(response.body(), new TypeToken<List<ResponseDialog>>() {
                    }.getType());
                    dialogs.stream().forEach(responseDialog -> {
                        list.add(new ItemDialog(
                                responseDialog.getId(),
                                responseDialog.getName(),
                                responseDialog.getAuthor(),
                                responseDialog.getUsername()));
                    });
                    adapter = new DialogAdapter(list, this);
                    this.view.setAdapter(adapter);
                }, throwable -> throwable.printStackTrace());
    }

    @Override
    public void clickSelectDialog(int position) {
        ItemDialog dialog = list.get(position);
        Intent intent = new Intent(view.getContext(), MessageActivity.class);
        intent.putExtra("id_dialog", dialog.getId());
        view.openPage(intent);
    }

    @Override
    public void clickInfoDialog(int position) {
        ItemDialog dialog = list.get(position);
        Intent intent = new Intent(view.getContext(), EditDialogActivity.class);
        intent.putExtra("id_dialog", dialog.getId());
        view.openPage(intent);
    }

    @Override
    public void clickAddDialog() {
        Intent intent = new Intent(view.getContext(), CreateNewDialogActivity.class);
        view.openPage(intent);
    }

    

    @Inject
    public DialogsPresenter() {
    }
}
