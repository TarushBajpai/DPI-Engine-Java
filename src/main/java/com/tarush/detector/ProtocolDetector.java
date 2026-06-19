package com.tarush.detector;

import com.tarush.model.TCPHeader;

public class ProtocolDetector {
    public static String getProtocol(int port){
        switch(port){
            case 21: return "FTP";
            case 22: return "SSH";
            case 25: return "SMTP";
            case 53: return "DNS";
            case 80: return "HTTP";
            case 443: return "HTTPS";
            default: return "UNKNOWN";
        }
    }
    public static String detect(TCPHeader tcp){
        int destinationPort = tcp.getDestinationPort();
        String protocol = getProtocol(destinationPort);
        if(protocol.equals("UNKNOWN")){
            protocol = getProtocol(tcp.getSourcePort());
        }
        return protocol;
    }
}
