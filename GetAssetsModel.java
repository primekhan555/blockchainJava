package com.example.blockchain;


public class GetAssetsModel {
    private String hardwareId, name, type, owner;

    public GetAssetsModel(String hardwareId, String hardwareName, String hardwareType, String hardwareOwner) {
        this.hardwareId = hardwareId;
        this.name = hardwareName;
        this.type = hardwareType;
        this.owner = hardwareOwner;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public String getHardwareName() {
        return name;
    }

    public String getHardwareType() {
        return type;
    }

    public String getHardwareOwner() {
        return owner;
    }
}
