package com.tarush.factory;

import com.tarush.pcap.CapturedPacket;
import com.tarush.pcap.PCAPReader;

import java.io.IOException;
import java.util.List;

public class PacketFactory {

    public static List<CapturedPacket> createPacket() {

        try {

            PCAPReader pcapReader = new PCAPReader();

            return pcapReader.readPackets("udp_test.pcap");

        } catch (IOException e) {

            e.printStackTrace();

            return List.of();
        }
    }
}