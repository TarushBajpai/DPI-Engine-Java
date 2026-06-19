package com.tarush.model;

public class IPHeader {
    private int version;
    private int headerLength;
    private int totalLength;
    private String sourceIP;
    private String destinationIP;
    private int protocol;
    public IPHeader(int version, int headerLength, int totalLength, String sourceIP, String destinationIP, int protocol){
        this.version = version;
        this.headerLength = headerLength;
        this.totalLength = totalLength;
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.protocol = protocol;
    }
    //getters
    public int getVersion() {
        return version;
    }
    public int getHeaderLength() {
        return headerLength;
    }
    public int getTotalLength() {
        return totalLength;
    }
    public String getSourceIP() {
        return sourceIP;
    }
    public String getDestinationIP() {
        return destinationIP;
    }
    public int getProtocol() {
        return protocol;
    }

    @Override
    public String toString() {
        return "Version: " + version +
                "\nHeader Length: " + headerLength +
                "\nTotal Length: " + totalLength +
                "\nProtocol: " + protocol +
                "\nSource IP: " + sourceIP +
                "\nDestination IP: " + destinationIP;
    }
}
