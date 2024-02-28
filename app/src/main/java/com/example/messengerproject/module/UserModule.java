package com.example.messengerproject.module;

import com.example.messengerproject.component.DataManager;
import com.example.messengerproject.component.UserManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Provides
    @Singleton
    UserManager provideUserManager() {
        return new UserManager();
    }
}
