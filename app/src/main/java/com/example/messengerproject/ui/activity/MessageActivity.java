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
import com.example.messengerproject.data.adapter.MessageAdapter;
import com.example.messengerproject.databinding.ActivityMessageBinding;
import com.example.messengerproject.ui.interfaces.IMessageBase;
import com.example.messengerproject.ui.presenter.MessagePresenter;

import javax.inject.Inject;

public class MessageActivity extends AppCompatActivity implements IMessageBase.IView {

    ActivityMessageBinding binding;

    @Inject
    MessagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_message);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message);

        initPresenter();
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {
        initToolBar();
        binding.btnSend.setOnClickListener(view -> {
            presenter.clickButtonSendMessage();
        });
    }

    private void initToolBar(){
        //setSupportActionBar(binding.toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setAdapter(MessageAdapter adapter) {
        binding.listMessage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listMessage.setAdapter(adapter);
    }

    @Override
    public String getTextMessage() {
        String text = binding.etEnterMessage.getText().toString();
        binding.etEnterMessage.getText().clear();
        return text;
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