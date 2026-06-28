package com.tarush.detector;

import com.tarush.model.IPHeader;

public class TransportProtocolDetector {
    public static String getProtocol(int protocolNumber){
        switch(protocolNumber){
            case 1: return "ICMP";
            case 6: return "TCP";
            case 17: return "UDP";
            default: return "UNKNOWN";
        }
    }
    public static String detect(IPHeader ip){
        int protocol = ip.getProtocol();
        return  getProtocol(protocol);
    }
}
