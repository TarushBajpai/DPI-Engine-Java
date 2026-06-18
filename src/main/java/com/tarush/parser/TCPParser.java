package com.tarush.parser;

public class TCPParser {

        public static int parsePort(byte high, byte low) {

            return ((high & 0xFF) << 8) | (low & 0xFF);

    }
}
