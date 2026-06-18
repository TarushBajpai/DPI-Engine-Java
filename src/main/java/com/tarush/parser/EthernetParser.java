package com.tarush.parser;

import com.tarush.model.EthernetHeader;

public class EthernetParser {
    private static String macAddress(byte[] packet,int offset){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(String.format("%02X", packet[offset + i] & 0xFF) );
            if(i!=5) sb.append(":");
        }
        return sb.toString();
    }
    public static EthernetHeader parse(byte[] packet , int offset){

        String destinationMAC = macAddress(packet,offset);
        String sourceMAC = macAddress(packet,offset+6);
        int etherType = ((packet[offset+12] & 0xFF ) << 8) | (packet[offset+13] & 0xFF);

        return new EthernetHeader(destinationMAC,sourceMAC,etherType);
    }
}
