package com.example.messengerproject.component;

import android.app.Activity;
import android.content.Intent;

public interface IViewBase {

    void initView();

    void openPage(Intent intent);

    Activity getActivity();
}
