package com.tarush.factory;

import com.tarush.pcap.PCAPReader;

public class PacketFactory {
    public static byte[] createPacket(){
        PCAPReader pcapReader = new PCAPReader();
        byte[] pkt = pcapReader.readFirstPacket("ipv4_cipso_option.pcap");
        return pkt;
    }
}
