package com.tarush.pcap;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class PCAPReader {
    public static List<byte[]> readPacket(String filePath) {

        try(FileInputStream fis = new FileInputStream(filePath)) {

//            for(int i = 0; i < 16; i++){
//                System.out.printf("%02X ", packetHeader[i] & 0xFF);
//            }
//            System.out.println();

           List<byte[]> packets = new ArrayList<>();

            // skipping the global header of 24B
            long skip = fis.skip(24);

            while (true){
                // read packet header of 16B
                byte[] packetHeader = new byte[16];
                int headerRead = fis.read(packetHeader);
                if(headerRead==-1) break;
                if (headerRead < 16) {
                    System.out.println("Warning: Corrupted file. Extracted a partial header of " + headerRead + " bytes.");
                    break;
                }
                // extract packet data length (actual packet ) from the header
                // little endian
                int packetLength = (packetHeader[8] & 0xFF)
                        | ((packetHeader[9] & 0xFF) << 8)
                        | ((packetHeader[10] & 0xFF) << 16)
                        | ((packetHeader[11] & 0xFF) << 24);
                // creating a new array for actual packet
                byte[] pkt = new byte[packetLength];
                // read the packet data and store it into packet array
                //  the pkt will be read from current cursor positon
                int dataRead = fis.read(pkt);
                if (dataRead < packetLength) {
                    System.out.println("Corrupted packet.");
                    break;
                }
                packets.add(pkt);

            }

            // packet header has 4 fields timestamp 0-3, timestamp 4-7, capturedLength 8-11,originalLength 12-15;
            // captured length tells us size of data packet ; we only need this field;
//            int packetLength = ((packetHeader[8]  & 0xFF) << 24) |
//                    ((packetHeader[9]  & 0xFF) << 16) |
//                    ((packetHeader[10] & 0xFF) << 8)  |
//                    (packetHeader[11]  & 0xFF);
            return packets;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
