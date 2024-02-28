package com.example.messengerproject.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.data.adapter.DialogRecipientAdapter;
import com.example.messengerproject.data.item.ItemAddParticipant;
import com.example.messengerproject.data.model.User;
import com.example.messengerproject.databinding.ActivityEditDialogBinding;
import com.example.messengerproject.ui.interfaces.IEditDialogBase;
import com.example.messengerproject.ui.interfaces.listener.AddNewParticipantFragmentListener;
import com.example.messengerproject.ui.presenter.EditDialogPresenter;

import java.util.List;

import javax.inject.Inject;

public class EditDialogActivity extends AppCompatActivity implements IEditDialogBase.IView, AddNewParticipantFragmentListener {

    ActivityEditDialogBinding binding;

    @Inject
    EditDialogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setContentView(R.layout.activity_edit_dialog);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_dialog);

        initPresenter();
    }

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void initView() {

        binding.frameClose.setOnClickListener(v -> {
            presenter.clickButtonClose();
        });

        binding.frameEditName.setOnClickListener(v -> {
            presenter.clickEditName();
        });

        binding.addRecepientContainer.setOnClickListener(v -> {
            presenter.clickAddNewRecipient();
        });

        binding.deleteDialogContainer.setOnClickListener(v -> {
            presenter.clickDeleteDialog();
        });

        binding.btnAgree.setOnClickListener(v -> {
            presenter.clickButtonAgree();
        });

        binding.btnCancel.setOnClickListener(v -> {
            presenter.clickButtonCancel();
        });

        binding.enterNameDialog.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus){
                presenter.unfocusedEnterNameDialog();
            }
        });
    }

    @Override
    public void onClose(Fragment fragment) {
        presenter.onClose(fragment);
    }

    @Override
    public void onClickButtonAddParticipant(Fragment fragment, List<User> participants) {
        presenter.onClickButtonAddParticipant(fragment, participants);
    }

    @Override
    public void setVisibilityEnterNameDialog(int visibility) {
        binding.enterNameDialog.setVisibility(visibility);
    }

    @Override
    public void setVisibilityLabelDialogName(int visibility) {
        binding.labelDialogName.setVisibility(visibility);
    }

    @Override
    public void setNameDialog(String name) {
        binding.labelDialogName.setText(name);
    }

    @Override
    public void setEnterNameDialog(String name) {
        binding.enterNameDialog.setText(name);
    }

    @Override
    public void setAuthorDialog(String author) {
        binding.dialogAuthor.setText(author);
    }

    @Override
    public void focusEnter() {
        binding.enterNameDialog.requestFocus();
    }

    @Override
    public String getNameDialog() {
        return binding.labelDialogName.getText().toString();
    }

    @Override
    public String getEnterNameDialog() {
        return binding.enterNameDialog.getText().toString();
    }

    @Override
    public void setVisibilityAddRecepientContainer(int visibility) {
        binding.addRecepientContainer.setVisibility(visibility);
    }

    @Override
    public void setVisibilityDeleteDialogContainer(int visibility) {
        binding.deleteDialogContainer.setVisibility(visibility);
    }

    @Override
    public void setVisibilityTopContainer(int visibility) {
        binding.topContainer.setVisibility(visibility);
    }

    @Override
    public void setAdapter(DialogRecipientAdapter adapter) {
        binding.listRecipientDialog.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.listRecipientDialog.setAdapter(adapter);
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

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}