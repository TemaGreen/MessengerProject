package com.example.messengerproject.ui.presenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.messengerproject.R;
import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.data.adapter.DialogRecipientAdapter;
import com.example.messengerproject.data.item.ItemAddParticipant;
import com.example.messengerproject.data.item.ItemDialogRecepient;
import com.example.messengerproject.data.model.ResponseDialog;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.fragment.AddNewParticipantFragment;
import com.example.messengerproject.ui.interfaces.IEditDialogBase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import retrofit2.Response;

public class EditDialogPresenter implements IEditDialogBase.IPresenter {

    IEditDialogBase.IView view;

    private List<ItemDialogRecepient> list;

    private DialogRecipientAdapter adapter;

    @Inject
    DataManager dataManager;

    private int id_dialog;

    @Override
    public void attachView(IEditDialogBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        initData();
        initAdapter();
        view.initView();
    }

    @SuppressLint("CheckResult")
    private void initData() {
        id_dialog = view.getIntent().getIntExtra("id_dialog", 0);

        dataManager.getDialogById(id_dialog).subscribe(response -> {
            ResponseDialog responseDialog = new Gson().fromJson(response.body(), ResponseDialog.class);
            view.setNameDialog(responseDialog.getName());
            view.setAuthorDialog(responseDialog.getUsername());
        }, throwable -> throwable.printStackTrace());
    }

    @SuppressLint("CheckResult")
    private void initAdapter() {
        dataManager.getParticipantById(id_dialog).subscribe(response -> {
            List<User> participants = new Gson().fromJson(response.body(), new TypeToken<List<User>>() {
            }.getType());
            list = participants.stream()
                    .map(user -> new ItemDialogRecepient(user.getId(), user.getName(), user.getIcon()))
                    .collect(Collectors.toList());
            adapter = new DialogRecipientAdapter(list, this);
            view.setAdapter(adapter);
        }, throwable -> throwable.printStackTrace());
    }

    @Override
    public void clickEditName() {
        String name = view.getNameDialog();
        view.setVisibilityLabelDialogName(View.INVISIBLE);
        view.setEnterNameDialog(name);
        view.setVisibilityEnterNameDialog(View.VISIBLE);
        view.focusEnter();
    }

    @Override
    public void clickAddNewRecipient() {
        Bundle bundle = new Bundle();
        bundle.putInt("id_dialog", id_dialog);
        view.setVisibilityTopContainer(View.INVISIBLE);
        view.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, AddNewParticipantFragment.class, bundle)
                .commit();
    }

    @Override
    @SuppressLint("CheckResult")
    public void clickDeleteDialog() {
        System.out.println("Удален");
        view.showToast("Диалог Удален");
        /*
        dataManager.deleteDialog(id_dialog).subscribe(response -> {
        }, throwable -> throwable.printStackTrace());
        */
    }

    @Override
    public void clickButtonAgree() {
        String name = view.getNameDialog();
    }

    @Override
    public void clickButtonCancel() {
        view.finish();
    }

    @Override
    public void clickButtonClose() {
        view.finish();
    }

    @Override
    public void unfocusedEnterNameDialog() {
        String name = view.getEnterNameDialog();
        view.setVisibilityEnterNameDialog(View.INVISIBLE);
        view.setNameDialog(name);
        view.setVisibilityLabelDialogName(View.VISIBLE);
    }

    @Override
    public void onClose(Fragment fragment) {
        view.setVisibilityTopContainer(View.VISIBLE);
        view.getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .commit();
    }

    @Override
    @SuppressLint("CheckResult")
    public void onClickButtonAddParticipant(Fragment fragment, List<User> participants) {
        dataManager.addParticipant(id_dialog, participants).subscribe(response ->{
            List<User> addedUsers = new Gson().fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
            adapter.setList(addedUsers.stream().map(user -> new ItemDialogRecepient(user)).collect(Collectors.toList()));
            adapter.notifyDataSetChanged();
            view.setVisibilityTopContainer(View.VISIBLE);
            view.getSupportFragmentManager().beginTransaction()
                    .remove(fragment)
                    .commit();
        }, throwable -> throwable.printStackTrace());
    }

    @Override
    public void deleteRecepient() {

    }

    @Inject
    public EditDialogPresenter() {
    }
}
