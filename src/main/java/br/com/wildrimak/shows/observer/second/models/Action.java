package br.com.wildrimak.shows.observer.second.models;

import java.time.OffsetDateTime;

public class Action {

    private String generalMessage;
    private Profile ownerAction;
    private Profile sufferAction;
    private String sufferMessage;
    private OffsetDateTime time;

    public Action(String generalMessage, Profile ownerAction) {
        this.generalMessage = generalMessage;
        this.ownerAction = ownerAction;
        this.sufferAction = Profile.getNullProfile();
        this.sufferMessage = "";
        this.time = OffsetDateTime.now();
    }

    public Action(String generalMessage, Profile ownerAction, String sufferMessage, Profile sufferAction) {
        this.generalMessage = generalMessage;
        this.ownerAction = ownerAction;
        this.sufferAction = sufferAction;
        this.sufferMessage = sufferMessage;
        this.time = OffsetDateTime.now();
    }

    public String getGeneralMessage() {
        return generalMessage;
    }

    public Profile getOwnerAction() {
        return ownerAction;
    }

    public Profile getSufferAction() {
        return sufferAction;
    }

    public String getSufferMessage() {
        return sufferMessage;
    }

    public OffsetDateTime getTime() {
        return time;
    }
}
