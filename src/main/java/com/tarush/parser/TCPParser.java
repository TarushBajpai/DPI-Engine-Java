package com.tarush.parser;
import com.tarush.model.TCPHeader;

public class TCPParser {

    public static TCPHeader parse(byte[] packet, int offset) {
         int sourcePort = ((packet[offset] & 0xFF) << 8) | (packet[offset+1] & 0xFF);
         int destinationPort = ((packet[offset+2] & 0xFF) << 8) | (packet[offset+3] & 0xFF);
         long sequenceNumber = ((long)(packet[offset + 4] & 0xFF) << 24)
                        | ((long)(packet[offset + 5] & 0xFF) << 16)
                        | ((long)(packet[offset + 6] & 0xFF) << 8)
                        | ((long)(packet[offset + 7] & 0xFF));
         long acknowledgmentNumber = ((long)(packet[offset + 8] & 0xFF) << 24)
                        | ((long)(packet[offset + 9] & 0xFF) << 16)
                        | ((long)(packet[offset +10] & 0xFF) << 8)
                        | ((long)(packet[offset +11] & 0xFF));
        int dataOffset = ((packet[offset + 12] >> 4) & 0xF) * 4;
        boolean fin = (packet[offset+13] & 0x01) != 0;
        boolean syn = (packet[offset+13] & 0x02) != 0;
        boolean rst = (packet[offset+13] & 0x04) != 0;
        boolean psh = (packet[offset+13] & 0x08) != 0;
        boolean ack = (packet[offset+13] & 0x10) != 0;
        boolean urg = (packet[offset+13] & 0x20) != 0;
        return new TCPHeader(sourcePort,
                destinationPort,
                sequenceNumber,
                acknowledgmentNumber,
                dataOffset,
                fin,syn,rst,psh,ack,urg);
    }
}
