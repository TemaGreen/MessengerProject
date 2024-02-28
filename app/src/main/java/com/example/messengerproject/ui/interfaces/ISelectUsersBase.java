package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.data.adapter.SelectUserAdapter;

public interface ISelectUsersBase {

    interface IView extends IViewBase {

        void setAdapter(SelectUserAdapter adapter);

    }

    interface IPresenter extends IPresenterBase<ISelectUsersBase.IView> {

        void clickButtonNewUser();
    }
}
