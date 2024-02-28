package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.data.adapter.MessageAdapter;

public interface IMessageBase {

    interface IView extends IViewBase {

        void setAdapter(MessageAdapter adapter);

        String getTextMessage();

    }

    interface IPresenter extends IPresenterBase<IView>{

        void clickButtonSendMessage();
    }
}
