package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.data.adapter.DialogAdapter;

public interface IDialogsBase {

    interface IView extends IViewBase {

        void setAdapter(DialogAdapter adapter);

    }

    interface IPresenter extends IPresenterBase<IDialogsBase.IView> {

        void clickSelectDialog(int position);

        void clickInfoDialog(int position);

        void clickAddDialog();
    }
}
