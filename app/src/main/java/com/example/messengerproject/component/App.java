package com.example.messengerproject.component;

import android.app.Application;

import com.example.messengerproject.module.DataModule;
import com.example.messengerproject.module.MessageModule;
import com.example.messengerproject.module.UserModule;

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildComponent();
    }

    protected AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .dataModule(new DataModule())
                //.userModule(new UserModule())
                //.messageModule(new MessageModule())
                .build();
    }
}
