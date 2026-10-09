package com.tarush.security;

import com.tarush.flow.Flow;

import java.util.ArrayList;
import java.util.List;

public class SecurityRuleEngine {

    public List<SecurityAlert> analyze(Flow flow) {

        List<SecurityAlert> alerts = new ArrayList<>();

        // Rule 1: unusually high packet rate
        if (flow.getPacketsPerSecond() > 1000) {

            alerts.add(
                    new SecurityAlert(
                            "HIGH_PACKET_RATE",
                            "HIGH",
                            "Flow generated more than 1000 packets per second"
                    )
            );
        }

        return alerts;
    }
}