package com.tarush.model;

public class ICMPHeader {

    private int type;
    private int code;
    private int checksum;

    public ICMPHeader(int type, int code, int checksum) {
        this.type = type;
        this.code = code;
        this.checksum = checksum;
    }

    public int getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    public int getChecksum() {
        return checksum;
    }

    @Override
    public String toString() {
        return "Type: " + type +
                "\nCode: " + code +
                "\nChecksum: " + String.format("0x%04X", checksum);
    }
}