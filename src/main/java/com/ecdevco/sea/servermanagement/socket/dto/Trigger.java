package com.ecdevco.sea.servermanagement.socket.dto;

import java.io.Serializable;

public class Trigger implements Serializable {

    private String type;
    private String command;
    private String[] args;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
