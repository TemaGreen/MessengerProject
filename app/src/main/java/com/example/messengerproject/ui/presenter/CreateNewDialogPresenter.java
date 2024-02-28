package com.example.messengerproject.ui.presenter;

import android.content.Intent;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.UserManager;
import com.example.messengerproject.data.adapter.CreateNewDialogAdapter;
import com.example.messengerproject.data.item.ItemAddUser;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.activity.DialogsActivity;
import com.example.messengerproject.ui.interfaces.ICreateNewDialogBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class CreateNewDialogPresenter implements ICreateNewDialogBase.IPresenter {

    ICreateNewDialogBase.IView view;

    @Inject
    DataManager dataManager;

    @Inject
    UserManager userManager;

    private CreateNewDialogAdapter adapter;

    private List<ItemAddUser> list;

    @Override
    public void attachView(ICreateNewDialogBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        initAdapter();
        this.view.initView();
    }

    private void initAdapter(){
        dataManager.getUsers().subscribe(response ->{
            int author = userManager.getUser().getId();
            List<User> users = new Gson().fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
            list = users.stream()
                    .filter(user -> user.getId() != author)
                    .map(user -> new ItemAddUser(user.getId(), user.getName(), user.getIcon()))
                    .collect(Collectors.toList());
            adapter = new CreateNewDialogAdapter(list, this);
            this.view.setAdapter(adapter);
        });
    }

    @Override
    public void clickItem(int position) {
        list.get(position).toggle();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void clickCreateDialog() {
        List<Integer> idUserSelected = list.stream()
                .filter(itemAddUser -> itemAddUser.isSelected())
                .map(ItemAddUser::getId)
                .collect(Collectors.toList());
        dataManager.createDialog(idUserSelected, view.getDialogName(), userManager.getUser().getId()).subscribe(response -> {
            Intent intent = new Intent(view.getContext(), DialogsActivity.class);
            this.view.openPage(intent);
        }, throwable -> throwable.printStackTrace());
    }

    @Inject
    public CreateNewDialogPresenter() {
    }
}
