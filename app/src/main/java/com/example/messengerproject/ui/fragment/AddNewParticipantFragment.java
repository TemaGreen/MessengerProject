package com.example.messengerproject.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.messengerproject.R;
import com.example.messengerproject.component.App;
import com.example.messengerproject.data.adapter.AddParticipantAdapter;
import com.example.messengerproject.databinding.FragmentAddNewParticipantBinding;
import com.example.messengerproject.ui.interfaces.IAddNewParticipantBase;
import com.example.messengerproject.ui.interfaces.listener.AddNewParticipantFragmentListener;
import com.example.messengerproject.ui.presenter.AddNewParticipantPresenter;

import javax.inject.Inject;

public class AddNewParticipantFragment extends Fragment implements IAddNewParticipantBase.IVew {

    FragmentAddNewParticipantBinding binding;

    @Inject
    AddNewParticipantPresenter presenter;

    private void initPresenter(){
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_participant, container, false);

        initPresenter();
        return binding.getRoot();
    }

    @Override
    public void initView() {
        binding.frameCloseFragment.setOnClickListener(v -> {
            presenter.onClose(this);
        });
        binding.btnAddParticipant.setOnClickListener(v -> {
            presenter.onClickBtnAddParticipant(this);
        });
        binding.searchUser.addTextChangedListener(presenter);
    }

    @Override
    public void setAdapter(AddParticipantAdapter adapter) {
        binding.listUser.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.listUser.setAdapter(adapter);
    }

    @Override
    public String getSearchText() {
        return binding.searchUser.getText().toString();
    }

    @Override
    public void openPage(Intent intent) {
        startActivity(intent);
    }

    @Override
    public Intent getIntent() {
        return null;
    }

}