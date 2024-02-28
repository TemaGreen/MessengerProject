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
import com.example.messengerproject.data.adapter.CreateNewDialogAdapter;
import com.example.messengerproject.databinding.ActivityCreateNewDialogBinding;
import com.example.messengerproject.ui.interfaces.ICreateNewDialogBase;
import com.example.messengerproject.ui.presenter.CreateNewDialogPresenter;

import javax.inject.Inject;

public class CreateNewDialogActivity extends AppCompatActivity implements ICreateNewDialogBase.IView {

    ActivityCreateNewDialogBinding binding;

    @Inject
    CreateNewDialogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_create_new_dialog);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_new_dialog);

        initPresenter();
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {
        binding.btnCreateDialog.setOnClickListener(v -> presenter.clickCreateDialog());
    }

    @Override
    public void setAdapter(CreateNewDialogAdapter adapter) {
        binding.listSelectUserAddDialog.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listSelectUserAddDialog.setAdapter(adapter);
    }

    @Override
    public String getDialogName() {
        return binding.enterNameDialog.getText().toString();
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