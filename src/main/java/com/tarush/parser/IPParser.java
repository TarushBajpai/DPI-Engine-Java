package com.tarush.parser;

public class IPParser {

        public static void parseVersionAndIHL(byte firstByte) {

            int version = (firstByte >> 4) & 0xF;
            int ihl = firstByte & 0xF;

            System.out.println("Version : IPv" + version);
            System.out.println("Header Length : " + (ihl * 4) + " bytes");
        }

    }

