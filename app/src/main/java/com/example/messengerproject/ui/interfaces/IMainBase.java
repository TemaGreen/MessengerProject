package com.example.messengerproject.ui.interfaces;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.ui.activity.MainActivity;

public interface IMainBase  {

    interface IView extends IViewBase {

    }

    interface IPresenter extends IPresenterBase<IView> {

        void attachView(MainActivity view);

        void clickButtonSelectUserFirst();

        void clickButtonSelectUser();

        void clickButtonNewUser();
    }
}
