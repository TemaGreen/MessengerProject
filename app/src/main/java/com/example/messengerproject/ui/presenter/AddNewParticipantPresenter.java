package com.example.messengerproject.ui.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.data.adapter.AddParticipantAdapter;
import com.example.messengerproject.data.item.ItemAddParticipant;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.ui.interfaces.IAddNewParticipantBase;
import com.example.messengerproject.ui.interfaces.listener.AddNewParticipantFragmentListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class AddNewParticipantPresenter implements IAddNewParticipantBase.IPresenter, TextWatcher {

    IAddNewParticipantBase.IVew view;

    private AddNewParticipantFragmentListener listener;

    @Inject
    DataManager dataManager;

    AddParticipantAdapter adapter;

    List<ItemAddParticipant> list;

    private int id;

    @Override
    public void attachView(IAddNewParticipantBase.IVew view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        initListener();
        initData();
        initAdapter();
        view.initView();
    }

    private void initListener(){
        FragmentActivity activity = this.view.getActivity();
        try {
            listener = (AddNewParticipantFragmentListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnCloseFragmentListener");
        }
    }

    private void initData(){
        id = view.requireArguments().getInt("id_dialog");
    }

    @SuppressLint("CheckResult")
    private void initAdapter() {
        dataManager.getUserCanAdded(id).subscribe(response -> {
            List<User> users = new Gson().fromJson(response.body(), new TypeToken<List<User>>(){
            }.getType());
            list = users.stream()
                    .map(user -> new ItemAddParticipant(user))
                    .collect(Collectors.toList());
            adapter = new AddParticipantAdapter(list, this);
            this.view.setAdapter(adapter);
            }, throwable -> throwable.printStackTrace()
        );
    }

    @Override
    public void onClose(Fragment fragment) {
        listener.onClose(fragment);
    }

    @Override
    public void onClickBtnAddParticipant(Fragment fragment) {
        List<User> participants = adapter.getListSelectedItems();
        listener.onClickButtonAddParticipant(fragment, participants);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        filterList();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClickItem(ItemAddParticipant item) {
        item.flagToggle();
        filterList();
        adapter.notifyDataSetChanged();
    }

    private void filterList(){
        String search = view.getSearchText();
        if(search.isEmpty()){
            adapter.setList(list);
        } else {
            List<ItemAddParticipant> listFound = list.stream()
                    .filter(item -> item.getName().toLowerCase().contains(search.toLowerCase()) || item.isFlag())
                    .collect(Collectors.toList());
            adapter.setList(listFound);
        }
    }

    @Inject
    public AddNewParticipantPresenter() {
    }
}
