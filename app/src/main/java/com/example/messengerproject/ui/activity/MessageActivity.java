package com.example.messengerproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.databinding.ActivityMessangeBinding;
import com.example.messengerproject.ui.interfaces.IMessageBase;
import com.example.messengerproject.ui.presenter.MessagePresenter;

import javax.inject.Inject;

public class MessageActivity extends AppCompatActivity implements IMessageBase.IView {

    ActivityMessangeBinding binding;

    @Inject
    MessagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messange);
        App.getAppComponent().inject(this);
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

    @Override
    public void setAdapter() {

    }
}