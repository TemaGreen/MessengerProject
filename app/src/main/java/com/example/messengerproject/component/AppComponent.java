package com.example.messengerproject.component;

import com.example.messengerproject.module.DataModule;
import com.example.messengerproject.module.MessageModule;
import com.example.messengerproject.module.UserModule;
import com.example.messengerproject.ui.activity.CreateNewDialogActivity;
import com.example.messengerproject.ui.activity.CreateNewUserActivity;
import com.example.messengerproject.ui.activity.DialogsActivity;
import com.example.messengerproject.ui.activity.EditDialogActivity;
import com.example.messengerproject.ui.activity.EditUserActivity;
import com.example.messengerproject.ui.activity.MainActivity;
import com.example.messengerproject.ui.activity.MessageActivity;
import com.example.messengerproject.ui.activity.SelectUsersActivity;
import com.example.messengerproject.ui.fragment.AddNewParticipantFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {DataModule.class, UserModule.class, MessageModule.class })
@Singleton
public interface AppComponent {

    void inject(MainActivity activity);

    void inject(DialogsActivity activity);

    void inject(MessageActivity activity);

    void inject(SelectUsersActivity activity);

    void inject(CreateNewDialogActivity activity);

    void inject(CreateNewUserActivity activity);

    void inject(EditDialogActivity editDialogActivity);

    void inject(EditUserActivity editUserActivity);

    void inject(AddNewParticipantFragment fragment);
}
