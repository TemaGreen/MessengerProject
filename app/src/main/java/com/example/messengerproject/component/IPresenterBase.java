package com.example.messengerproject.component;

public interface IPresenterBase<T extends IViewBase> {

    void attachView(T view);

    void detachView();

    void viewIsReady();
}
