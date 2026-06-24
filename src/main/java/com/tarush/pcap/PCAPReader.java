package com.tarush.pcap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PCAPReader {
    public static byte[] readFirstPacket(String filePath) {

        try(FileInputStream fis = new FileInputStream(filePath)) {
            // skipping the global header of 24B
            long skip = fis.skip(24);
            // read first packet header of 16B
            byte[] packetHeader = new byte[16];
            fis.read(packetHeader);
            for(int i = 0; i < 16; i++){
                System.out.printf("%02X ", packetHeader[i] & 0xFF);
            }
            System.out.println();
            // packet header has 4 fields timestamp 0-3, timestamp 4-7, capturedLength 8-11,originalLength 12-15;
            // captured length tells us size of data packet ; we only need this field;
//            int packetLength = ((packetHeader[8]  & 0xFF) << 24) |
//                    ((packetHeader[9]  & 0xFF) << 16) |
//                    ((packetHeader[10] & 0xFF) << 8)  |
//                    (packetHeader[11]  & 0xFF);

            // little endian
            int packetLength = (packetHeader[8] & 0xFF)
                            | ((packetHeader[9] & 0xFF) << 8)
                            | ((packetHeader[10] & 0xFF) << 16)
                            | ((packetHeader[11] & 0xFF) << 24);
            System.out.println("packet length : "+packetLength);
            byte[] packet = new byte[packetLength];
            fis.read(packet);
            return packet;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
