package com.tarush.parser;
import com.tarush.model.IPHeader;
public class IPParser {

        public static IPHeader parse(byte[] packet, int offset){
            int version = (packet[offset]>>4) & 0xF ;
            int ihl = packet[offset] & 0xF;
            int headerLength = ihl*4;
            int totalLength = ((packet[offset+2]& 0xFF)<<8) | (packet[offset+3] & 0xFF);
            int protocol = packet[offset+9] & 0xFF;

            String sourceIP = (packet[offset+12] & 0xFF) + "." +
                    (packet[offset+13] & 0xFF)+ "." +
                    (packet[offset+14] & 0xFF) + "." +
                    (packet[offset+15] & 0xFF);

            String destinationIP = (packet[offset+16] & 0xFF) + "." +
                    (packet[offset+17] & 0xFF) + "." +
                    (packet[offset+18] & 0xFF) + "." +
                    (packet[offset+19] & 0xFF);


            return  new IPHeader(version,headerLength,totalLength,sourceIP,destinationIP,protocol);
        }

    }

