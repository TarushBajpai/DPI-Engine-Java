package com.tarush.flow;

import java.util.Objects;

public class FlowKey {

    private final String ip1;
    private final String ip2;

    private final int port1;
    private final int port2;

    private final String protocol;

    public FlowKey(
            String ip1,
            int port1,
            String ip2,
            int port2,
            String protocol) {

        // Normalize the two endpoints so that
        // A -> B and B -> A produce the same key.

        if (compareEndpoints(ip1, port1, ip2, port2) <= 0) {
            this.ip1 = ip1;
            this.port1 = port1;
            this.ip2 = ip2;
            this.port2 = port2;
        } else {
            this.ip1 = ip2;
            this.port1 = port2;
            this.ip2 = ip1;
            this.port2 = port1;
        }

        this.protocol = protocol;
    }

    private int compareEndpoints(
            String ip1,
            int port1,
            String ip2,
            int port2) {

        int ipComparison = ip1.compareTo(ip2);

        if (ipComparison != 0) {
            return ipComparison;
        }

        return Integer.compare(port1, port2);
    }

    public String getIp1() {
        return ip1;
    }

    public String getIp2() {
        return ip2;
    }

    public int getPort1() {
        return port1;
    }

    public int getPort2() {
        return port2;
    }

    public String getProtocol() {
        return protocol;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof FlowKey)) {
            return false;
        }

        FlowKey flowKey = (FlowKey) o;

        return port1 == flowKey.port1
                && port2 == flowKey.port2
                && Objects.equals(ip1, flowKey.ip1)
                && Objects.equals(ip2, flowKey.ip2)
                && Objects.equals(protocol, flowKey.protocol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                ip1,
                port1,
                ip2,
                port2,
                protocol
        );
    }

    @Override
    public String toString() {

        return ip1 + ":" + port1
                + " <-> "
                + ip2 + ":" + port2
                + " [" + protocol + "]";
    }
}