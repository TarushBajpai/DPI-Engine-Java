package com.tarush.model;

public class UDPHeader {

    private int sourcePort;
    private int destinationPort;
    private int length;
    private int checksum;

    public UDPHeader(int sourcePort, int destinationPort, int length, int checksum) {
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.length = length;
        this.checksum = checksum;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public int getLength() {
        return length;
    }

    public int getChecksum() {
        return checksum;
    }

    @Override
    public String toString() {
        return "Source Port: " + sourcePort +
                "\nDestination Port: " + destinationPort +
                "\nLength: " + length +
                "\nChecksum: " + String.format("0x%04X", checksum);
    }
}