package com.tarush;
import com.tarush.parser.IPParser;
import com.tarush.parser.TCPParser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Deep Packet Inspection Engine Started");

//        byte firstByte = 0x45;
//        IPParser.parseVersionAndIHL(firstByte);
//
//        byte high = (byte) 0x01;
//        byte low = (byte) 0xBB;
//        int port = TCPParser.parsePort(high, low);
//        System.out.println("Destination Port : " + port);
        byte[] packet = new byte[34];
        packet[14] = 0x45;              // Version + IHL

        packet[16] = 0x00;
        packet[17] = 0x3C;              // Total Length = 60

        packet[23] = 0x06;              // Protocol = TCP

        packet[26] = (byte)192;
        packet[27] = (byte)168;
        packet[28] = 1;
        packet[29] = 10;

        packet[30] = 8;
        packet[31] = 8;
        packet[32] = 8;
        packet[33] = 8;
    }
}