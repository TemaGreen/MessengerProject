package com.example.messengerproject.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ResponseMessage implements Parcelable {

    int id;

    int dialogs;

    int author;

    int icon;

    String name;

    String text;

    long time;

    protected ResponseMessage(Parcel in) {
        this.id = in.readInt();
        this.dialogs = in.readInt();
        this.author = in.readInt();
        this.icon = in.readInt();
        this.name = in.readString();
        this.text = in.readString();
        this.time = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(dialogs);
        parcel.writeInt(author);
        parcel.writeInt(icon);
        parcel.writeString(name);
        parcel.writeString(text);
        parcel.writeLong(time);
    }

    public static final Creator<ResponseMessage> CREATOR = new Creator<ResponseMessage>() {
        @Override
        public ResponseMessage createFromParcel(Parcel parcel) {
            return new ResponseMessage(parcel);
        }

        @Override
        public ResponseMessage[] newArray(int i) {
            return new ResponseMessage[i];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDialogs() {
        return dialogs;
    }

    public void setDialogs(int dialogs) {
        this.dialogs = dialogs;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ResponseMessage(int id, int dialogs, int author, int icon, String name, String text, long time) {
        this.id = id;
        this.dialogs = dialogs;
        this.author = author;
        this.icon = icon;
        this.name = name;
        this.text = text;
        this.time = time;
    }

    public ResponseMessage() {
    }
}
