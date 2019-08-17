package com.ecdevco.sea.servermanagement.domain.dto;

public class SocketInfo {

    private String address;
    private int established;
    private int listen;
    private int timeWait;
    private int closeWait;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEstablished() {
        return established;
    }

    public void setEstablished(int established) {
        this.established = established;
    }

    public int getListen() {
        return listen;
    }

    public void setListen(int listen) {
        this.listen = listen;
    }

    public int getTimeWait() {
        return timeWait;
    }

    public void setTimeWait(int timeWait) {
        this.timeWait = timeWait;
    }

    public int getCloseWait() {
        return closeWait;
    }

    public void setCloseWait(int closeWait) {
        this.closeWait = closeWait;
    }
}
