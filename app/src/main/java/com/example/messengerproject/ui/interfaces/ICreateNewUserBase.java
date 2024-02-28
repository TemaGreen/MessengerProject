package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;

public interface ICreateNewUserBase {

    interface IView extends IViewBase {

        String getUsername();
    }

    interface IPresenter extends IPresenterBase<IView> {

        void clickImageContainer();

        void clickCancelBtn();

        void clickBtnOk();
    }
}
