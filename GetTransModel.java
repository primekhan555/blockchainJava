package com.example.blockchain;

public class GetTransModel {
    private String hardware, newOwner, transactionId, timestamp;

    public GetTransModel(String hardware, String newOwner, String transactionId, String timestamp) {
        this.hardware = hardware;
        this.newOwner = newOwner;
        this.transactionId = transactionId;
        this.timestamp = timestamp;
    }

    public String getHardware() {
        return hardware;
    }

    public String getNewOwner() {
        return newOwner;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTimeStamp() {
        return timestamp;
    }
}
