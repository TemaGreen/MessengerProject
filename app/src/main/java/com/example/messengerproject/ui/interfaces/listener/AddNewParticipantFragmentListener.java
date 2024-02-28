package com.example.messengerproject.ui.interfaces.listener;

import androidx.fragment.app.Fragment;

import com.example.messengerproject.data.model.User;

import java.util.List;

public interface AddNewParticipantFragmentListener {

        void onClose(Fragment fragment);

        void onClickButtonAddParticipant(Fragment fragment, List<User> participants);
}
