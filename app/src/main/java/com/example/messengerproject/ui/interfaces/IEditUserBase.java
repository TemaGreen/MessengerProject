package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;

public interface IEditUserBase {

    interface IView extends IViewBase {

    }

    interface IPresenter extends IPresenterBase<IView> {

    }
}
