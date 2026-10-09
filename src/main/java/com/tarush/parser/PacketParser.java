package com.tarush.parser;

import com.tarush.detector.ApplicationProtocolDetector;
import com.tarush.detector.TransportProtocolDetector;
import com.tarush.model.*;

public class PacketParser {

    private static final int ETHERNET_HEADER_LENGTH = 14;
    private static final int ETHERNET_OFFSET = 0;
    private static final int IPV4_ETHERTYPE = 0x0800;

    public static Packet parse(byte[] packet, long timestampSeconds, long timestampMicroseconds) {

        // Ethernet
        EthernetHeader ethernet =
                EthernetParser.parse(packet, ETHERNET_OFFSET);

        if (ethernet.getEtherType() != IPV4_ETHERTYPE) {
            return null;
        }

        // IPv4
        IPHeader ip =
                IPParser.parse(packet, ETHERNET_HEADER_LENGTH);

        // Transport protocol
        String transportProtocol =
                TransportProtocolDetector.detect(ip);

        int transportOffset =
                ETHERNET_HEADER_LENGTH + ip.getHeaderLength();

        // Default values
        TCPHeader tcp = null;
        UDPHeader udp = null;
        ICMPHeader icmp = null;

        String applicationProtocol = "UNKNOWN";
        String payloadString = "NO PAYLOAD";
        HTTPRequest request = null;
        if ("TCP".equals(transportProtocol)) {

            tcp = TCPParser.parse(packet, transportOffset);

            applicationProtocol =
                    ApplicationProtocolDetector.detect(tcp);

            int payloadOffset =
                    transportOffset + tcp.getDataOffset();

            payloadString =
                    PayloadParser.parse(packet, payloadOffset);

            if ("HTTP".equals(applicationProtocol)) {
                request = HTTPParser.extract(payloadString);
            }
        }
        else if ("UDP".equals(transportProtocol)) {

            udp = UDPParser.parse(packet, transportOffset);
        }
        else if ("ICMP".equals(transportProtocol)) {

            icmp = ICMPParser.parse(packet, transportOffset);
        }

        return new Packet(
                ethernet,
                ip,
                tcp,
                udp,
                icmp,
                transportProtocol,
                applicationProtocol,
                payloadString,
                request,
                timestampSeconds,
                timestampMicroseconds
        );
    }
}