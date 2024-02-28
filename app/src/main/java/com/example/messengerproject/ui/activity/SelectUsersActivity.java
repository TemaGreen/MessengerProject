package com.example.messengerproject.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.data.adapter.SelectUserAdapter;
import com.example.messengerproject.databinding.ActivitySelectUsersBinding;
import com.example.messengerproject.ui.interfaces.ISelectUsersBase;
import com.example.messengerproject.ui.presenter.SelectUsersPresenter;

import javax.inject.Inject;

public class SelectUsersActivity extends AppCompatActivity implements ISelectUsersBase.IView {

    private ActivitySelectUsersBinding binding;

    @Inject
    SelectUsersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_select_users);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_users);

        initPresener();
    }

    private void initPresener(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {
        binding.btnAddNewUser.setOnClickListener(v -> {
            presenter.clickButtonNewUser();
        });
    }

    @Override
    public void setAdapter(SelectUserAdapter adapter) {
        binding.listSelectUser.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listSelectUser.setAdapter(adapter);
    }

    @Override
    public void openPage(Intent intent) {
        startActivity(intent);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }
}