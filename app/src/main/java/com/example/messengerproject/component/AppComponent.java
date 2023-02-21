package com.example.messengerproject.component;

import com.example.messengerproject.module.DataModule;
import com.example.messengerproject.ui.activity.MessageActivity;

import dagger.Component;

@Component(modules = {DataModule.class, MessageManager.class})
public interface AppComponent {

    void inject(MessageActivity activity);
}
