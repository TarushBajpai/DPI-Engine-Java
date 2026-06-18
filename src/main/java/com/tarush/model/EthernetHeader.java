package com.tarush.model;

public class EthernetHeader {

    private String destinationMAC;
    private String sourceMAC;
    private int etherType;

    public EthernetHeader(String destinationMAC, String sourceMAC, int etherType){
        this.destinationMAC = destinationMAC;
        this.sourceMAC = sourceMAC;
        this.etherType = etherType;
    }

    //getters
    public String getDestinationMAC() {
        return destinationMAC;
    }
    public String getSourceMAC() {
        return sourceMAC;
    }
    public int getEtherType() {
        return etherType;
    }

}
