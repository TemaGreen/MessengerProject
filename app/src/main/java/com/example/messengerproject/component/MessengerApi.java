package com.example.messengerproject.component;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MessengerApi {

    //Все сообщения
    @GET("/message/all")
    Observable<Response<JsonElement>> getMessages();

    //Конкретное сообщения
    @GET("/message/{id}")
    Observable<Response<JsonElement>> getMessageById(@Path("id") int id);

    //Все Сообщения в диалоге
    @POST("/messages-dialog")
    Observable<Response<JsonElement>> getDialogMessage(@Body JsonObject jsonObject);

    //Сообщения в диалоге от определенного времени
    @POST("/messages-dialog-time")
    Observable<Response<JsonElement>> getDialogMessageByTime(@Body JsonObject jsonObject);

    //Все сообщения пользователя в диалоге
    @POST("/messages-dialog-user")
    Observable<Response<JsonElement>> getDialogUserMessage(@Body JsonObject jsonObject);

    //Получение сообщений пользователя в диалоге от определенного времени
    @POST("/messages-dialog-time-user")
    Observable<Response<JsonElement>> getDialogUserMessageByTime(@Body JsonObject jsonObject);

    @POST("/send-message")
    Observable<Response<JsonElement>> sendMessage(@Body JsonObject jsonObject);

    //Изменение сообщения
    @PUT("/edit-message")
    Observable<Response<JsonElement>> editMessage(@Body JsonObject jsonObject);

    //Добавление Нового пользователя
    @POST("/user-new-add")
    Observable<Response<JsonElement>> addNewUser(@Body JsonObject jsonObject);

    //Изменение пользователя
    @PUT("/user-change")
    Observable<Response<JsonElement>> editUser(@Body JsonObject jsonObject);

    //Удаление пользователя
    @DELETE("/user-delete")
    Observable<Response> deleteUser(@Body JsonObject jsonObject);

    //Получение списка всех пользователей
    @GET("/user/all")
    Observable<Response<JsonElement>> getUsers();

    //Получение конкретного пользователя по id-шнику
    @GET("/user/{id}")
    Observable<Response<JsonElement>> getUserById(@Path("id") int id);

    //Получение пользователя по имени
    @POST("/user-name")
    Observable<Response<JsonElement>> getUserByName(@Body JsonObject jsonObject);

    //Получение списка участников диалога по id-шнику диалога
    @GET("/participant/{id}")
    Observable<Response<JsonElement>> getParticipantById(@Path("id") int id);

    @POST("/participant/can-added")
    Observable<Response<JsonElement>> getUserCanAdded(@Body JsonObject jsonObject);

    //Добавить новых участников диалога
    @POST("/participant/add")
    Observable<Response<JsonElement>> addParticipant(@Body JsonElement jsonElement);

    //Получение списка диалогов
    @GET("/dialog/all")
    Observable<Response<JsonElement>> getDialogs();

    //Получение диалога по id-шнику
    @GET("/dialog/{id}")
    Observable<Response<JsonElement>> getDialogById(@Path("id") int id);

    //Удаление диалога по id-шнику
    @DELETE("/dialog-delete")
    Observable<Response> deleteDialogById(@Body JsonObject jsonObject);

    //Получение диалогов по id-шнику создателя
    @GET("/dialogs-user/{id}")
    Observable<Response<JsonElement>> getDialogsByUserId(@Path("id") int id);

    //Получение диалогов по имени создателя
    @POST("/dialogs-user")
    Observable<Response<JsonElement>> getDialogsByUserName(@Body JsonObject jsonObject);

    @POST("/dialog-new")
    Observable<Response<JsonElement>> createDialogUser(@Body JsonElement jsonElement);

}