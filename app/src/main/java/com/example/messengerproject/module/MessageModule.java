package com.example.messengerproject.module;

import com.example.messengerproject.component.MessageManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MessageModule {

    @Provides
    @Singleton
    MessageManager provideMessageManager() {
        return new MessageManager();
    }
}
