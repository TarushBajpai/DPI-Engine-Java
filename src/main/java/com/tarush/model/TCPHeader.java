package com.tarush.model;

public class TCPHeader {

    private int sourcePort;
    private int destinationPort;
    private long sequenceNumber;
    private long acknowledgmentNumber;
    private int dataOffset;

    private boolean fin;
    private boolean syn;
    private boolean rst;
    private boolean psh;
    private boolean ack;
    private boolean urg;

    public TCPHeader(
            int sourcePort,
            int destinationPort,
            long sequenceNumber,
            long acknowledgmentNumber,
            int dataOffset,
            boolean fin, boolean syn, boolean rst, boolean psh, boolean ack, boolean urg) {

        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.sequenceNumber = sequenceNumber;
        this.acknowledgmentNumber = acknowledgmentNumber;
        this.dataOffset = dataOffset;
        this.fin = fin;
        this.syn = syn;
        this.rst = rst;
        this.psh = psh;
        this.ack = ack;
        this.urg = urg;
    }

    //getters
    public int getSourcePort() {
        return sourcePort;
    }
    public int getDestinationPort() {
        return destinationPort;
    }
    public long getSequenceNumber() {
        return sequenceNumber;
    }
    public long getAcknowledgementNumber() {
        return acknowledgmentNumber;
    }
    public int getDataOffset() {
        return dataOffset;
    }

    public boolean isFin() {
        return fin;
    }
    public boolean isSyn() {
        return syn;
    }
    public boolean isRst() {
        return rst;
    }
    public boolean isPsh() {
        return psh;
    }
    public boolean isAck() {
        return ack;
    }
    public boolean isUrg() {
        return urg;
    }

    @Override
    public String toString() {
        return "Source Port: " + sourcePort +
                "\nDestination Port: " + destinationPort +
                "\nSequence Number: " + sequenceNumber +
                "\nAcknowledgment Number: " + acknowledgmentNumber +
                "\nData Offset: " + dataOffset +
                "\nFIN: " + fin +
                "\nSYN: " + syn +
                "\nRST: " + rst +
                "\nPSH: " + psh +
                "\nACK: " + ack +
                "\nURG: " + urg;
    }
}
