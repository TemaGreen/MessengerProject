package com.example.messengerproject.component;

import android.database.Observable;

import com.example.messengerproject.data.item.ItemMessage;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MessengerApi {

    @GET("/messages")
    Observable<List<ItemMessage>> getMessages();

    @POST("/send-message")
    Observable<Response<ItemMessage>> sendMessage(@Body JsonObject jsonObject);

}
