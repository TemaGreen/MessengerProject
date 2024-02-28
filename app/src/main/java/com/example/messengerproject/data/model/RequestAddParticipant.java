package com.example.messengerproject.data.model;

import java.util.List;

public class RequestAddParticipant {

    int dialog;

    List<User> participants;

    public int getDialog() {
        return dialog;
    }

    public void setDialog(int dialog) {
        this.dialog = dialog;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public RequestAddParticipant(int dialog, List<User> participants) {
        this.dialog = dialog;
        this.participants = participants;
    }

    public RequestAddParticipant() {
    }
}
