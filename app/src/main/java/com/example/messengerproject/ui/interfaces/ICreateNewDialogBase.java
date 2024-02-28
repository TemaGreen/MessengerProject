package com.example.messengerproject.ui.interfaces;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.data.adapter.CreateNewDialogAdapter;

public interface ICreateNewDialogBase {

    interface IView extends IViewBase {

        void setAdapter(CreateNewDialogAdapter adapter);

        String getDialogName();

    }

    interface IPresenter extends IPresenterBase<IView> {

        void clickItem(int position);

        void clickCreateDialog();
    }
}
