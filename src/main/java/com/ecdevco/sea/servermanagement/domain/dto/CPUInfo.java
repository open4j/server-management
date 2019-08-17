package com.ecdevco.sea.servermanagement.domain.dto;

public class CPUInfo {

    private long idle;
    private long rawUser;
    private long rawNice;
    private long rawSystem;
    private long rawIdle;
    private long rawWait;
    private long rawKernel;

    public long getIdle() {
        return idle;
    }

    public void setIdle(long idle) {
        this.idle = idle;
    }

    public long getRawUser() {
        return rawUser;
    }

    public void setRawUser(long rawUser) {
        this.rawUser = rawUser;
    }

    public long getRawNice() {
        return rawNice;
    }

    public void setRawNice(long rawNice) {
        this.rawNice = rawNice;
    }

    public long getRawSystem() {
        return rawSystem;
    }

    public void setRawSystem(long rawSystem) {
        this.rawSystem = rawSystem;
    }

    public long getRawIdle() {
        return rawIdle;
    }

    public void setRawIdle(long rawIdle) {
        this.rawIdle = rawIdle;
    }

    public long getRawWait() {
        return rawWait;
    }

    public void setRawWait(long rawWait) {
        this.rawWait = rawWait;
    }

    public long getRawKernel() {
        return rawKernel;
    }

    public void setRawKernel(long rawKernel) {
        this.rawKernel = rawKernel;
    }
}
