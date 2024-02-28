package com.example.messengerproject.ui.presenter;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.ui.interfaces.ICreateNewUserBase;

import javax.inject.Inject;

public class CreateNewUserPresenter implements ICreateNewUserBase.IPresenter {

    private ICreateNewUserBase.IView view;

    @Inject
    DataManager dataManager;

    @Override
    public void attachView(ICreateNewUserBase.IView view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {
        view.initView();
    }

    @Override
    public void clickImageContainer() {

    }

    @Override
    public void clickCancelBtn() {

    }

    @Override
    public void clickBtnOk() {
        String name = this.view.getUsername();
        //dataManager.createUser(name, )
    }

    @Inject
    public CreateNewUserPresenter() {
    }
}
