package com.ecdevco.sea.servermanagement.domain.dto;

public class MemInfo {

    private long total;
    private long free;
    private long buffered;
    private long cached;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getFree() {
        return free;
    }

    public void setFree(long free) {
        this.free = free;
    }

    public long getBuffered() {
        return buffered;
    }

    public void setBuffered(long buffered) {
        this.buffered = buffered;
    }

    public long getCached() {
        return cached;
    }

    public void setCached(long cached) {
        this.cached = cached;
    }
}
