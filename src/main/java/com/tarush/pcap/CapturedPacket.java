package com.tarush.pcap;

public class CapturedPacket {

    private final byte[] data;
    private final long timestampSeconds;
    private final long timestampMicroseconds;
    private final int capturedLength;
    private final int originalLength;

    public CapturedPacket(
            byte[] data,
            long timestampSeconds,
            long timestampMicroseconds,
            int capturedLength,
            int originalLength) {

        this.data = data;
        this.timestampSeconds = timestampSeconds;
        this.timestampMicroseconds = timestampMicroseconds;
        this.capturedLength = capturedLength;
        this.originalLength = originalLength;
    }

    public byte[] getData() {
        return data;
    }

    public long getTimestampSeconds() {
        return timestampSeconds;
    }

    public long getTimestampMicroseconds() {
        return timestampMicroseconds;
    }

    public int getCapturedLength() {
        return capturedLength;
    }

    public int getOriginalLength() {
        return originalLength;
    }
}