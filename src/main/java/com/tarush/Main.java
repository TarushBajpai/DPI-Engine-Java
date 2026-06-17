package com.tarush;
import com.tarush.parser.IPParser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Deep Packet Inspection Engine Started");
        byte firstByte = 0x45;
        IPParser.parseVersionAndIHL(firstByte);
    }
}