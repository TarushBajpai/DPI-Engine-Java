package com.tarush.parser;

import com.tarush.detector.ProtocolDetector;
import com.tarush.model.EthernetHeader;
import com.tarush.model.IPHeader;
import com.tarush.model.TCPHeader;

public class PacketParser {
    public static void parse(byte[] packet){
        EthernetHeader ethernet = EthernetParser.parse(packet, 0);
        IPHeader ip = IPParser.parse(packet, 14);
        int tcpOffset = 14 + ip.getHeaderLength();
        TCPHeader tcp = TCPParser.parse(packet, tcpOffset);

        System.out.println("ethernet header: "+ ethernet);
        System.out.println("IP header: "+ ip);
        System.out.println("TCP header: "+ tcp);

        String applicationProtocol = ProtocolDetector.detect(tcp);
        System.out.println("Application Protocol: " + applicationProtocol);

        int payloadOffset = 14 + ip.getHeaderLength() + tcp.getDataOffset();
        String payload = PayloadParser.parse(packet, payloadOffset);
        System.out.println(payload);
    }
}
