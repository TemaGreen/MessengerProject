package com.example.messengerproject.module;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.MessageManager;
import com.example.messengerproject.component.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new DataManager();
    }
}
