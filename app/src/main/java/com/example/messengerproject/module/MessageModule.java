package com.example.messengerproject.module;

import com.example.messengerproject.component.MessageManager;

import dagger.Module;
import dagger.Provides;

@Module
public class MessageModule {

    @Provides
    MessageManager provideMessageManager(){
        return new MessageManager();
    }
}
