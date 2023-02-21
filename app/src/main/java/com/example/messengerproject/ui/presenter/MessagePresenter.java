package com.example.messengerproject.ui.presenter;

import com.example.messengerproject.ui.interfaces.IMessageBase;

import javax.inject.Inject;

public class MessagePresenter implements IMessageBase.IPresenter {

    IMessageBase.IView view;

    @Override
    public void attachView(IMessageBase.IView view) {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void viewIsReady() {

    }

    @Inject
    public MessagePresenter() {
    }
}
