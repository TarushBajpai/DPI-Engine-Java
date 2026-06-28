package com.tarush.parser;

import com.tarush.detector.ApplicationProtocolDetector;
import com.tarush.detector.TransportProtocolDetector;
import com.tarush.model.*;

public class PacketParser {
    private static final int ETHERNET_HEADER_LENGTH = 14;
    private static final int ETHERNET_OFFSET = 0;
    private static final int IPV4_ETHERTYPE = 0x0800;

    public static Packet parse(byte[] packet) {

        // ethernet
        EthernetHeader ethernet = EthernetParser.parse(packet, ETHERNET_OFFSET);
        if (ethernet.getEtherType() == IPV4_ETHERTYPE)
        {
            IPHeader ip = IPParser.parse(packet, ETHERNET_HEADER_LENGTH);
            String transportProtocol = TransportProtocolDetector.detect(ip); //IP protocol

            if ("TCP".equals(transportProtocol))
            {

                int tcpOffset = ETHERNET_HEADER_LENGTH + ip.getHeaderLength();
                TCPHeader tcp = TCPParser.parse(packet, tcpOffset);

                // protocol
                String applicationProtocol = ApplicationProtocolDetector.detect(tcp);

                //  payload
                int payloadOffset = ETHERNET_HEADER_LENGTH + ip.getHeaderLength() + tcp.getDataOffset();

                String payloadString = PayloadParser.parse(packet, payloadOffset);
                HTTPRequest request = null;
                if ("HTTP".equals(applicationProtocol))
                    request = HTTPParser.extract(payloadString);

                return new Packet(ethernet, ip, tcp, applicationProtocol, payloadString, request);
            } else if("UDP".equals(transportProtocol)) {
                System.out.println("Transport Protocol : UDP (parser not implemented yet)");
            } else if ("ICMP".equals(transportProtocol)) {
                System.out.println("Transport Protocol : ICMP (parser not implemented yet)");
            }
        }
        return null;
    }
}


