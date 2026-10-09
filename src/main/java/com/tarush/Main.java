package com.tarush;
import com.tarush.pcap.CapturedPacket;
import com.tarush.factory.PacketFactory;
import com.tarush.flow.Flow;
import com.tarush.model.Packet;
import com.tarush.parser.PacketParser;
import com.tarush.flow.FlowTracker;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Deep Packet Inspection Engine Started");

        List<CapturedPacket> packets = PacketFactory.createPacket();
        FlowTracker flowTracker = new FlowTracker();
        for(int i = 0; i<packets.size(); i++){
            CapturedPacket capturedPacket = packets.get(i);
            Packet parsedPacket =
                    PacketParser.parse(
                            capturedPacket.getData(),
                            capturedPacket.getTimestampSeconds(),
                            capturedPacket.getTimestampMicroseconds()
                    );

            System.out.println("========== Packet " + (i + 1) + " ==========");

            if (parsedPacket != null) {
                System.out.println(parsedPacket);
                flowTracker.addPacket(parsedPacket);
            }
        }
        System.out.println("\n========== FLOWS ==========");

        for (Flow flow : flowTracker.getFlows().values()) {
            System.out.println(flow);
            System.out.println("----------------------------");
        }
    }
}