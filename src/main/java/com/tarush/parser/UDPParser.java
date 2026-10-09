package com.tarush.parser;

import com.tarush.model.UDPHeader;

public class UDPParser {

    public static UDPHeader parse(byte[] packet, int offset) {

        int sourcePort = ((packet[offset] & 0xFF) << 8)
                | (packet[offset + 1] & 0xFF);

        int destinationPort = ((packet[offset + 2] & 0xFF) << 8)
                | (packet[offset + 3] & 0xFF);

        int length = ((packet[offset + 4] & 0xFF) << 8)
                | (packet[offset + 5] & 0xFF);

        int checksum = ((packet[offset + 6] & 0xFF) << 8)
                | (packet[offset + 7] & 0xFF);

        return new UDPHeader(
                sourcePort,
                destinationPort,
                length,
                checksum
        );
    }
}