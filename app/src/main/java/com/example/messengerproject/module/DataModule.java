package com.example.messengerproject.module;

import com.example.messengerproject.component.DataManager;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    DataManager provideDataManager(){return new DataManager();}
}
