package com.tarush.parser;

import com.tarush.model.ICMPHeader;

public class ICMPParser {

    public static ICMPHeader parse(byte[] packet, int offset) {

        int type = packet[offset] & 0xFF;

        int code = packet[offset + 1] & 0xFF;

        int checksum = ((packet[offset + 2] & 0xFF) << 8)
                | (packet[offset + 3] & 0xFF);

        return new ICMPHeader(type, code, checksum);
    }
}