package com.tarush.model;

public class Packet {

    private EthernetHeader ethernetHeader;
    private IPHeader ipHeader;

    private TCPHeader tcpHeader;
    private UDPHeader udpHeader;
    private ICMPHeader icmpHeader;

    private String transportProtocol;
    private String applicationProtocol;
    private String payload;

    private HTTPRequest httpRequest;
    private final long timestampSeconds;
    private final long timestampMicroseconds;

    public Packet(
            EthernetHeader ethernetHeader,
            IPHeader ipHeader,
            TCPHeader tcpHeader,
            UDPHeader udpHeader,
            ICMPHeader icmpHeader,
            String transportProtocol,
            String applicationProtocol,
            String payload,
            HTTPRequest httpRequest,
            long timestampSeconds,
            long timestampMicroseconds) {

        this.ethernetHeader = ethernetHeader;
        this.ipHeader = ipHeader;
        this.tcpHeader = tcpHeader;
        this.udpHeader = udpHeader;
        this.icmpHeader = icmpHeader;
        this.transportProtocol = transportProtocol;
        this.applicationProtocol = applicationProtocol;
        this.payload = payload;
        this.httpRequest = httpRequest;
        this.timestampSeconds = timestampSeconds;
        this.timestampMicroseconds = timestampMicroseconds;
    }

    public EthernetHeader getEthernetHeader() {
        return ethernetHeader;
    }

    public IPHeader getIpHeader() {
        return ipHeader;
    }

    public TCPHeader getTcpHeader() {
        return tcpHeader;
    }

    public UDPHeader getUdpHeader() {
        return udpHeader;
    }

    public ICMPHeader getIcmpHeader() {
        return icmpHeader;
    }

    public String getTransportProtocol() {
        return transportProtocol;
    }

    public String getApplicationProtocol() {
        return applicationProtocol;
    }

    public String getPayload() {
        return payload;
    }

    public HTTPRequest getHttpRequest() {
        return httpRequest;
    }
    public long getTimestampSeconds() {
        return timestampSeconds;
    }

    public long getTimestampMicroseconds() {
        return timestampMicroseconds;
    }

    @Override
    public String toString() {

        return """
                ==============================
                Ethernet Header
                ==============================
                %s

                ==============================
                IP Header
                ==============================
                %s

                Transport Protocol: %s

                TCP Header:
                %s

                UDP Header:
                %s

                ICMP Header:
                %s

                Application Protocol: %s

                HTTP Request:
                %s
                """.formatted(
                ethernetHeader,
                ipHeader,
                transportProtocol,
                tcpHeader,
                udpHeader,
                icmpHeader,
                applicationProtocol,
                httpRequest
        );
    }
}