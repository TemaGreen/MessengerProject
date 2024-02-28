package com.example.messengerproject.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public interface IViewBase {

    void initView();

    void openPage(Intent intent);

    Activity getActivity();

    Context getContext();

    Intent getIntent();
}
