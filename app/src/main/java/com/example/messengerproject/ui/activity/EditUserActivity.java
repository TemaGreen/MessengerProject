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
import com.example.messengerproject.ui.interfaces.IEditUserBase;
import com.example.messengerproject.ui.presenter.EditUserPresenter;

import javax.inject.Inject;

public class EditUserActivity extends AppCompatActivity implements IEditUserBase.IView {

    ActivityCreateUserBinding binding;

    @Inject
    EditUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_edit_user);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_user);

        initPresenter();
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {

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