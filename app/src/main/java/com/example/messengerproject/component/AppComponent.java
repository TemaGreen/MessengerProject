package com.example.messengerproject.component;

import com.example.messengerproject.ui.activity.MessageActivity;

import dagger.Component;

@Component
public interface AppComponent {

    void inject(MessageActivity activity);
}
