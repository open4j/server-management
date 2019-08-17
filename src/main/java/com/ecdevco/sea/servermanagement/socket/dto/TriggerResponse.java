package com.ecdevco.sea.servermanagement.socket.dto;

import java.io.Serializable;

public class TriggerResponse implements Serializable {

    private Trigger trigger;
    private Object response;

    public TriggerResponse() {
    }

    public TriggerResponse(Trigger trigger) {
        this.trigger = trigger;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
