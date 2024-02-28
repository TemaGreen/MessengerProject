package com.example.messengerproject.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.databinding.ActivityMainBinding;
import com.example.messengerproject.ui.interfaces.IMainBase;
import com.example.messengerproject.ui.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainBase.IView {

    private ActivityMainBinding binding;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initPresenter();
    }

    private void initPresenter(){
        //presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    public void initView() {
        binding.btnSelectUserFirst.setOnClickListener(view -> {
            presenter.clickButtonSelectUserFirst();
        });
        binding.btnSelectUser.setOnClickListener(view -> {
            presenter.clickButtonSelectUser();
        });
        binding.btnNewUser.setOnClickListener(view -> {
            presenter.clickButtonNewUser();
        });
    }


    public void openPage(Intent intent) {
        startActivity(intent);
    }


    public Activity getActivity() {
        return this;
    }


    public Context getContext() {
        return this;
    }
}