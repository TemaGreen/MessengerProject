package com.example.messengerproject.component;


import com.example.messengerproject.BuildConfig;
import com.example.messengerproject.data.model.RequestAddParticipant;
import com.example.messengerproject.data.model.RequestCreateDialog;
import com.example.messengerproject.data.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {

    @Inject
    MessageManager messageManager;

    private MessengerApi messengerApi;

    public DataManager() {
        initRetrofit();
    }

    private void initRetrofit() {
        String url = BuildConfig.URL_API;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        messengerApi = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(MessengerApi.class);
    }

    //Все сообщения
    public Observable<Response<JsonElement>> getMessages() {
        return messengerApi.getMessages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Конкретное сообщения
    public Observable<Response<JsonElement>> getMessage(int id) {
        return messengerApi.getMessageById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Все Сообщения в диалоге
    public Observable<Response<JsonElement>> getDialogMessages(int id_dialog) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_dialog", id_dialog);
        return messengerApi.getDialogMessage(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Сообщения в диалоге от определенного времени
    public Observable<Response<JsonElement>> getDialogMessagesOverTime(int id_dialog, Timestamp time) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_dialogs", id_dialog);
        jsonObject.addProperty("time", time.getTime());
        return messengerApi.getDialogMessageByTime(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение сообщений пользователя в диалоге
    public Observable<Response<JsonElement>> getDialogMessages(int id_author, int id_dialogs) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_author", id_author);
        jsonObject.addProperty("id_dialogs", id_dialogs);
        return messengerApi.getDialogUserMessage(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение сообщений пользователя в диалоге от определенного времени
    public Observable<Response<JsonElement>> getDialogMessagesOverTime(int id_author, int id_dialog, Timestamp time) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_author", id_author);
        jsonObject.addProperty("id_dialogs", id_dialog);
        jsonObject.addProperty("time", time.getTime());
        return messengerApi.getDialogUserMessageByTime(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Отправка сообщения
    public Observable<Response<JsonElement>> sendMessage(int id_dialogs, int author, String text_message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_dialogs", id_dialogs);
        jsonObject.addProperty("id_author", author);
        jsonObject.addProperty("text_message", text_message);
        return messengerApi.sendMessage(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Изменение сообщения
    public Observable<Response<JsonElement>> editMessage(int id, int id_dialogs, String text_message, int id_author, String changeable_message) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("id_dialogs", id_dialogs);
        jsonObject.addProperty("text_message", text_message);
        jsonObject.addProperty("id_author", id_author);
        jsonObject.addProperty("changeable_message", changeable_message);
        return messengerApi.editMessage(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Добавление Нового пользователя
    public Observable<Response<JsonElement>> createUser(String name, int icon) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("icon", icon);
        return messengerApi.addNewUser(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Изменение пользователя
    public Observable<Response<JsonElement>> editUser(int id, String name, int icon, int changeable_user) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("icon", icon);
        jsonObject.addProperty("changeable_user", changeable_user);
        return messengerApi.editUser(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Удаление пользователя
    public Observable<Response> deleteUser(int id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        return messengerApi.deleteUser(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение списка всех пользователей
    public Observable<Response<JsonElement>> getUsers() {
        return messengerApi.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение конкретного пользователя по id-шнику
    public Observable<Response<JsonElement>> getUserById(int id) {
        return messengerApi.getUserById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение пользователя по имени
    public Observable<Response<JsonElement>> getUserByName(String name) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        return messengerApi.getUserByName(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение списка участников диалога по id-шнику диалога
    public Observable<Response<JsonElement>> getParticipantById(int id) {
        return messengerApi.getParticipantById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение списка пользователей которых можно добавить в диалог
    public Observable<Response<JsonElement>> getUserCanAdded(int dialog) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("dialog", dialog);
        return messengerApi.getUserCanAdded(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<JsonElement>> addParticipant(int dialog, List<User> participants){
        JsonElement jsonElement = new Gson().toJsonTree(new RequestAddParticipant(dialog, participants), new TypeToken<RequestAddParticipant>(){}.getType());
        return messengerApi.addParticipant(jsonElement)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение списка диалогов
    public Observable<Response<JsonElement>> getDialogs() {
        return messengerApi.getDialogs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение диалога по id-шнику
    public Observable<Response<JsonElement>> getDialogById(int id) {
        return messengerApi.getDialogById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Удаление диалога по id-шнику
    public Observable<Response> deleteDialog(int id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_dialog", id);
        return messengerApi.deleteDialogById(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение диалогов пользователя по id-шнику
    public Observable<Response<JsonElement>> getDialogsByUserId(int id) {
        return messengerApi.getDialogsByUserId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Получение диалогов пользователя по имени
    public Observable<Response<JsonElement>> getDialogsByUserName(String name) {
        JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", name);
        return messengerApi.getDialogsByUserName(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //Создание диалога
    public Observable<Response<JsonElement>> createDialog(List<Integer> usersSelected, String name, int author) {
        JsonElement jsonElement = new Gson().toJsonTree(new RequestCreateDialog(author, name, usersSelected), new TypeToken<RequestCreateDialog>(){}.getType());
        // JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();
        return messengerApi.createDialogUser(jsonElement)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}






















