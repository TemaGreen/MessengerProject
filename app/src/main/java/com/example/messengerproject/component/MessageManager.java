package com.example.messengerproject.component;

import javax.inject.Inject;

public class MessageManager {

    @Inject
    DataManager dataManager;

    @Inject
    UserManager userManager;

    public MessageManager() {
    }
}
