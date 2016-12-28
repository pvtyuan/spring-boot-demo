package com.example.response;

import java.util.Arrays;

/**
 * Created by Yuzhou on 2016/12/28.
 */
public class BasicResponse {
    private Integer statusNo;
    private String statusString;
    private BasicResponse success = new BasicResponse(Status.SUCCSS);

//    private static Map<Status, BasicResponse> cache;
//
//    static {
//        cache = new HashMap<>();
//    }

    private BasicResponse(Status status, String... message) {
        this.statusNo = status.getStatusNo();
        if (message != null) {
            this.statusString = status.getStatusString() + " :" + String.join("", message);
        }
        this.statusString = status.getStatusString();
    }

    public BasicResponse of(Status status, String message) {
       if (status == Status.SUCCSS) {
           return success;
       } else {
           return new BasicResponse(status, message);
       }
    }

    public Integer getStatusNo() {
        return statusNo;
    }

    public void setStatusNo(Integer statusNo) {
        this.statusNo = statusNo;
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }
}
