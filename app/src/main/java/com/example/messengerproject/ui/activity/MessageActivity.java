package com.example.messengerproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.data.adapter.MessageAdapter;
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
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setAdapter(MessageAdapter adapter) {
        binding.listMessage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listMessage.setAdapter(adapter);
    }

    @Override
    public void clearTextViewForEnterMessage() {
        binding.etEnterMessage.getText().clear();
    }

    @Override
    public String getEnterTextMessage() {
        return binding.etEnterMessage.getText().toString();
    }

    @Override
    public void openPage(Intent intent) {
        startActivity(intent);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

}