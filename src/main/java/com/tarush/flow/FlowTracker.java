package com.tarush.flow;

import com.tarush.model.Packet;

import java.util.HashMap;
import java.util.Map;

public class FlowTracker {

    private final Map<FlowKey, Flow> flows;

    public FlowTracker() {
        flows = new HashMap<>();
    }

    public void addPacket(Packet packet) {

        String protocol = packet.getTransportProtocol();

        String sourceIP = packet.getIpHeader().getSourceIP();
        String destinationIP = packet.getIpHeader().getDestinationIP();

        int sourcePort = 0;
        int destinationPort = 0;

        if ("TCP".equals(protocol)) {

            sourcePort = packet.getTcpHeader().getSourcePort();
            destinationPort = packet.getTcpHeader().getDestinationPort();

        } else if ("UDP".equals(protocol)) {

            sourcePort = packet.getUdpHeader().getSourcePort();
            destinationPort = packet.getUdpHeader().getDestinationPort();
        }

        FlowKey key = new FlowKey(
                sourceIP,
                sourcePort,
                destinationIP,
                destinationPort,
                protocol
        );

        Flow flow = flows.get(key);

        if (flow == null) {
            flow = new Flow(key);
            flows.put(key, flow);
        }

        int packetSize = packet.getIpHeader().getTotalLength();

        // Check which endpoint sent this packet.
        if (sourceIP.equals(key.getIp1())
                && sourcePort == key.getPort1()) {

            flow.addForwardPacket(packetSize);

        } else {

            flow.addReversePacket(packetSize);
        }
        flow.updateTimestamp(
                packet.getTimestampSeconds() * 1_000_000L
                        + packet.getTimestampMicroseconds()
        );
    }

    public Map<FlowKey, Flow> getFlows() {
        return flows;
    }
}