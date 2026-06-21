package com.tarush;

import com.tarush.factory.PacketFactory;
import com.tarush.model.Packet;
import com.tarush.parser.PacketParser;
import com.tarush.parser.PayloadParser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Deep Packet Inspection Engine Started");
        byte[] packet = PacketFactory.createPacket();
        Packet parse = PacketParser.parse(packet);
        System.out.println(parse);
    }

}