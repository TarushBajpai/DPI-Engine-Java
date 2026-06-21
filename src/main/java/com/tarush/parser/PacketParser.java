package com.tarush.parser;

import com.tarush.detector.ProtocolDetector;
import com.tarush.model.*;

public class PacketParser {
    public static Packet parse(byte[] packet) {

        final int ETHERNET_HEADER_LENGTH = 14;
        final int ethernetOffset = 0;

        // ethernet
        EthernetHeader ethernet = EthernetParser.parse(packet, ethernetOffset);

        // ip
        IPHeader ip = IPParser.parse(packet, ETHERNET_HEADER_LENGTH);

        // tcp
        int tcpOffset = ETHERNET_HEADER_LENGTH + ip.getHeaderLength();
        TCPHeader tcp = TCPParser.parse(packet, tcpOffset);

        // protocol
        String applicationProtocol = ProtocolDetector.detect(tcp);

        //  payload

        int payloadOffset = ETHERNET_HEADER_LENGTH + ip.getHeaderLength() + tcp.getDataOffset();

        String payloadString = PayloadParser.parse(packet, payloadOffset);
        HTTPRequest request = null;
        if ("HTTP".equals(applicationProtocol))
            request = HTTPParser.extract(payloadString);

        return new Packet(ethernet,ip,tcp,applicationProtocol,payloadString,request);
    }

}
