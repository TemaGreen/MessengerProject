package com.example.messengerproject.ui.presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.messengerproject.ui.interfaces.IMainBase;

import javax.inject.Inject;

public class MainPresenter implements IMainBase.IView {

    IMainBase.IView view;

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

    @Inject
    public MainPresenter(IMainBase.IView view) {
        this.view = view;
    }
}
