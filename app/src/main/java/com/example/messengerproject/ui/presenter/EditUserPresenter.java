package com.example.messengerproject.ui.presenter;

import com.example.messengerproject.ui.interfaces.IEditUserBase;

import javax.inject.Inject;

public class EditUserPresenter implements IEditUserBase.IPresenter {

    IEditUserBase.IView view;

    @Override
    public void attachView(IEditUserBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {

    }

    

    @Inject
    public EditUserPresenter() {
    }
}
