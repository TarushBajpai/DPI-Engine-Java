package com.tarush.factory;

import com.tarush.pcap.PCAPReader;

import java.util.List;

public class PacketFactory {
    public static List<byte[]> createPacket(){
        PCAPReader pcapReader = new PCAPReader();
        List<byte[]> pkt = pcapReader.readPacket("ipv4_cipso_option.pcap");
        return pkt;
    }
}
