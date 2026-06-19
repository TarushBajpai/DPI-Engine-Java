package com.tarush;

import com.tarush.parser.PacketParser;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Deep Packet Inspection Engine Started");

        // Total Minimum Size = 14 (Eth) + 20 (IP) + 20 (TCP) = 54 bytes
        byte[] packet = new byte[54];

// ==========================================
// 1. ETHERNET HEADER (Indices 0 to 13)
// ==========================================
// Destination MAC: 00:11:22:33:44:55
        packet[0] = (byte)0x00; packet[1] = (byte)0x11; packet[2] = (byte)0x22;
        packet[3] = (byte)0x33; packet[4] = (byte)0x44; packet[5] = (byte)0x55;

// Source MAC: 66:77:88:99:AA:BB
        packet[6] = (byte)0x66; packet[7] = (byte)0x77; packet[8] = (byte)0x88;
        packet[9] = (byte)0x99; packet[10] = (byte)0xAA; packet[11] = (byte)0xBB;

// EtherType: 0x0800 (IPv4)
        packet[12] = (byte)0x08;
        packet[13] = (byte)0x00;


// ==========================================
// 2. IPv4 HEADER (Indices 14 to 33)
// ==========================================
        packet[14] = (byte)0x45;        // Version (4) + IHL (5 words = 20 bytes)
        packet[15] = (byte)0x00;        // Type of Service (DSCP/ECN)
        packet[16] = (byte)0x00;        // Total Length High Byte
        packet[17] = (byte)0x28;        // Total Length Low Byte (0x0028 = 40 bytes for IP+TCP)
        packet[18] = (byte)0x12;        // Identification High Byte
        packet[19] = (byte)0x34;        // Identification Low Byte
        packet[20] = (byte)0x40;        // Flags (Don't Fragment) + Fragment Offset High
        packet[21] = (byte)0x00;        // Fragment Offset Low
        packet[22] = (byte)0x40;        // TTL (64)
        packet[23] = (byte)0x06;        // Protocol (6 = TCP)
        packet[24] = (byte)0x00;        // Header Checksum High (Ignored by basic parsers)
        packet[25] = (byte)0x00;        // Header Checksum Low
// Source IP: 192.168.1.10
        packet[26] = (byte)192;  packet[27] = (byte)168;  packet[28] = 1;  packet[29] = 10;
// Destination IP: 8.8.8.8
        packet[30] = 8;          packet[31] = 8;          packet[32] = 8;  packet[33] = 8;


// ==========================================
// 3. TCP HEADER (Indices 34 to 53)
// ==========================================
        packet[34] = (byte)0xC4;        // Source Port High Byte
        packet[35] = (byte)0x5C;        // Source Port Low Byte (0xC45C = Port 50268)
        packet[36] = (byte)0x00;        // Destination Port High Byte
        packet[37] = (byte)0x50;        // Destination Port Low Byte (0x0050 = Port 80, HTTP)

// Sequence Number (4 Bytes) - Mock value: 0x11223344
        packet[38] = (byte)0x11; packet[39] = (byte)0x22; packet[40] = (byte)0x33; packet[41] = (byte)0x44;

// Acknowledgment Number (4 Bytes) - Mock value: 0x00000000
        packet[42] = (byte)0x00; packet[43] = (byte)0x00; packet[44] = (byte)0x00; packet[45] = (byte)0x00;

// Data Offset + Flags Row
        packet[46] = (byte)0x50;        // Data Offset: 5 (5 words = 20 bytes TCP header) + Reserved bits
        packet[47] = (byte)0x02;        // Flags: 0x02 sets the SYN bit to 1 (Connection Request)

// Window Size (2 Bytes) - Mock value: 0xFAF0 (64240)
        packet[48] = (byte)0xFA;
        packet[49] = (byte)0xF0;

// TCP Checksum (2 Bytes)
        packet[50] = (byte)0x00;
        packet[51] = (byte)0x00;

// Urgent Pointer (2 Bytes)
        packet[52] = (byte)0x00;
        packet[53] = (byte)0x00;

        PacketParser.parse(packet);
    }

}