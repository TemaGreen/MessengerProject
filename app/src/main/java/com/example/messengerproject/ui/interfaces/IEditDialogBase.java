package com.example.messengerproject.ui.interfaces;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.data.adapter.DialogRecipientAdapter;
import com.example.messengerproject.data.model.User;

import java.util.List;

public interface IEditDialogBase {

    interface IView extends IViewBase {

        void setVisibilityEnterNameDialog(int visibility);

        void setVisibilityLabelDialogName(int visibility);

        void setNameDialog(String name);

        String getNameDialog();

        void setEnterNameDialog(String name);

        String getEnterNameDialog();

        void setAuthorDialog(String author);

        void setVisibilityAddRecepientContainer( int visibility);

        void setVisibilityDeleteDialogContainer( int visibility);

        void setVisibilityTopContainer(int visibility);

        void focusEnter();

        void setAdapter(DialogRecipientAdapter adapter);

        void showToast(String msg);

        void finish();

        FragmentManager getSupportFragmentManager();
    }

    interface IPresenter extends IPresenterBase<IView> {

        void clickEditName();

        void clickAddNewRecipient();

        void clickDeleteDialog();

        void clickButtonAgree();

        void clickButtonCancel();

        void clickButtonClose();

        void unfocusedEnterNameDialog();

        void deleteRecepient();

        void onClose(Fragment fragment);

        void onClickButtonAddParticipant(Fragment fragment, List<User> participants);
    }
}
