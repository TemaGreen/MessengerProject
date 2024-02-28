package com.example.messengerproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.databinding.ActivityCreateUserBinding;
import com.example.messengerproject.ui.interfaces.ICreateNewUserBase;
import com.example.messengerproject.ui.presenter.CreateNewUserPresenter;

import javax.inject.Inject;

public class CreateNewUserActivity extends AppCompatActivity implements ICreateNewUserBase.IView {

    private ActivityCreateUserBinding binding;

    @Inject
    CreateNewUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_create_user);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_user);

        initPresenter();
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {

        binding.frameBtnCancel.setOnClickListener(v -> {
            presenter.clickCancelBtn();
        });

        binding.frameImageUser.setOnClickListener(v -> {
            presenter.clickImageContainer();
        });

        binding.bottomContainer.setOnClickListener(v -> {
            presenter.clickImageContainer();
        });

        binding.btnOk.setOnClickListener(v -> {
            presenter.clickBtnOk();
        });
    }

    @Override
    public String getUsername(){
        return binding.enterUsername.getText().toString();
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