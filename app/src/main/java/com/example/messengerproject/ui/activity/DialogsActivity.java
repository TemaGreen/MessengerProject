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
import com.example.messengerproject.data.adapter.DialogAdapter;
import com.example.messengerproject.databinding.ActivityDialogsBinding;
import com.example.messengerproject.ui.interfaces.IDialogsBase;
import com.example.messengerproject.ui.presenter.DialogsPresenter;

import javax.inject.Inject;

public class DialogsActivity extends AppCompatActivity implements IDialogsBase.IView {

    private ActivityDialogsBinding binding;

    @Inject
    DialogsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_dialogs);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dialogs);

        initPresenter();
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {
        initToolBar();
        binding.btnNewDialog.setOnClickListener(v -> { presenter.clickAddDialog();});

    }

    private void initToolBar(){
        //setSupportActionBar(binding.toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setAdapter(DialogAdapter adapter) {
        binding.listDialogs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listDialogs.setAdapter(adapter);
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