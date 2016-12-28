package com.example.response;

/**
 * Created by Yuzhou on 2016/12/28.
 */
public enum  Status {
    SUCCSS("succss");

    private String statusString;

    Status(String statusString) {
        this.statusString = statusString;
    }

    public String getStatusString() {
        return statusString;
    }

    public int getStatusNo() {
        return ordinal();
    }
}
