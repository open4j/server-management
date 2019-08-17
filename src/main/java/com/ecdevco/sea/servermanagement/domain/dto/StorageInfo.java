package com.ecdevco.sea.servermanagement.domain.dto;

public class StorageInfo {

    private long total;
    private long used;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getUsed() {
        return used;
    }

    public void setUsed(long used) {
        this.used = used;
    }
}
