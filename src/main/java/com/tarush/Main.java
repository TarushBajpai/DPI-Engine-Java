package com.tarush;

import com.tarush.factory.PacketFactory;
import com.tarush.model.Packet;
import com.tarush.parser.PacketParser;
import com.tarush.parser.PayloadParser;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Deep Packet Inspection Engine Started");
        List<byte[]> packets = PacketFactory.createPacket();
        for(int i = 0; i<packets.size(); i++){
            Packet parsedPacket = PacketParser.parse(packets.get(i));

            System.out.println("========== Packet " + (i + 1) + " ==========");
            if (parsedPacket != null) {
                System.out.println(parsedPacket);
            }
        }
    }
}