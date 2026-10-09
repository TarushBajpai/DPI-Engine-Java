package com.tarush.flow;

public class Flow {

    private final FlowKey key;

    private int packetCount;
    private long totalBytes;

    private int forwardPackets;
    private int reversePackets;

    private long forwardBytes;
    private long reverseBytes;

    private long startTimestamp;
    private long endTimestamp;

    public Flow(FlowKey key) {
        this.key = key;
        this.packetCount = 0;
        this.totalBytes = 0;
        this.forwardPackets = 0;
        this.reversePackets = 0;
        this.forwardBytes = 0;
        this.reverseBytes = 0;
        this.startTimestamp = -1;
        this.endTimestamp = -1;
    }

    public void addForwardPacket(int packetSize) {
        packetCount++;
        totalBytes += packetSize;

        forwardPackets++;
        forwardBytes += packetSize;
    }

    public void addReversePacket(int packetSize) {
        packetCount++;
        totalBytes += packetSize;

        reversePackets++;
        reverseBytes += packetSize;
    }

    public FlowKey getKey() {
        return key;
    }

    public int getPacketCount() {
        return packetCount;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public int getForwardPackets() {
        return forwardPackets;
    }

    public int getReversePackets() {
        return reversePackets;
    }

    public long getForwardBytes() {
        return forwardBytes;
    }

    public long getReverseBytes() {
        return reverseBytes;
    }
    public long getDurationMicros() {

        if (startTimestamp == -1 || endTimestamp == -1) {
            return 0;
        }

        return endTimestamp - startTimestamp;
    }

    public void updateTimestamp(long timestampMicros) {

        if (startTimestamp == -1) {
            startTimestamp = timestampMicros;
        }

        endTimestamp = timestampMicros;
    }
    public double getPacketsPerSecond() {

        long durationMicros = getDurationMicros();

        if (durationMicros <= 0) {
            return 0;
        }

        return packetCount / (durationMicros / 1_000_000.0);
    }

    public double getBytesPerSecond() {

        long durationMicros = getDurationMicros();

        if (durationMicros <= 0) {
            return 0;
        }

        return totalBytes / (durationMicros / 1_000_000.0);
    }

    @Override
    public String toString() {

        return "Flow: " + key +
                "\nPackets: " + packetCount +
                "\nTotal Bytes: " + totalBytes +
                "\nForward Packets: " + forwardPackets +
                "\nReverse Packets: " + reversePackets +
                "\nForward Bytes: " + forwardBytes +
                "\nReverse Bytes: " + reverseBytes +
                "\nDuration: " + getDurationMicros() + " microseconds" +
                "\nPackets/sec: " + getPacketsPerSecond() +
                "\nBytes/sec: " + getBytesPerSecond();
    }
}