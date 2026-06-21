package com.tarush.model;

public class Packet {
    private EthernetHeader ethernetHeader;
    private IPHeader ipHeader;
    private TCPHeader tcpHeader;
    private String applicationProtocol;
    private String payload;
    private HTTPRequest httpRequest;

    public Packet(EthernetHeader ethernetHeader,
                  IPHeader ipHeader,
                  TCPHeader tcpHeader,
                  String applicationProtocol,
                  String payload,
                  HTTPRequest httpRequest){
        this.ethernetHeader = ethernetHeader;
        this.ipHeader = ipHeader;
        this.tcpHeader = tcpHeader;
        this.applicationProtocol = applicationProtocol;
        this.payload = payload;
        this.httpRequest = httpRequest;
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
    public String getApplicationProtocol() {
        return applicationProtocol;
    }
    public String getPayload() {
        return payload;
    }
    public HTTPRequest getHttpRequest() {
        return httpRequest;
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

            ==============================
            TCP Header
            ==============================
            %s

            Application Protocol: %s

            HTTP Request:
            %s
            """.formatted(
                ethernetHeader,
                ipHeader,
                tcpHeader,
                applicationProtocol,
                httpRequest
        );
    }
}
