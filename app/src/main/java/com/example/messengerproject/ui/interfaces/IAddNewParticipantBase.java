package com.example.messengerproject.ui.interfaces;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.messengerproject.component.IPresenterBase;
import com.example.messengerproject.component.IViewBase;
import com.example.messengerproject.data.adapter.AddParticipantAdapter;
import com.example.messengerproject.data.item.ItemAddParticipant;

import java.util.List;

public interface IAddNewParticipantBase {

    interface IVew extends IViewBase{

        void setAdapter(AddParticipantAdapter adapter);

        String getSearchText();

        Bundle requireArguments();

        FragmentActivity getActivity();
    }

    interface IPresenter extends IPresenterBase<IVew>{

        void onClickItem(ItemAddParticipant item);

        void onClose(Fragment fragment);

        void onClickBtnAddParticipant(Fragment fragment);
    }
}
