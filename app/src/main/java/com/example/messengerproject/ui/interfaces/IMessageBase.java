package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;

public interface IMessageBase {

    interface IView extends IViewBase {
        void setAdapter();
    }
    interface IPresenter extends IPresenterBase<IView>{

    }
}
