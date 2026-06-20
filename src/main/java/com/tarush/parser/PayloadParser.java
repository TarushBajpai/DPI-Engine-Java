package com.tarush.parser;

public class PayloadParser {
    public static String parse(byte[] packet, int payloadOffset) {
        StringBuilder sb = new StringBuilder();
        int n = packet.length;
        if(payloadOffset >= n) return "NO PAYLOAD";
        for(int i = payloadOffset; i<packet.length; i++){
            sb.append((char)(packet[i] & 0xFF));
        }
        return sb.toString();
    }
}
