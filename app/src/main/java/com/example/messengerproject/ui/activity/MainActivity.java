package com.example.messengerproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.messengerproject.R;
import com.example.messengerproject.ui.interfaces.IMainBase;
import com.example.messengerproject.ui.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainBase.IView {

    MainActivity binding;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {

    }

    @Override
    public void openPage(Intent intent) {

    }

    @Override
    public Activity getActivity() {
        return null;
    }
}