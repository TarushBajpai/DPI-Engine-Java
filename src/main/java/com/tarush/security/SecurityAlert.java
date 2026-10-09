package com.tarush.security;

public class SecurityAlert {

    private final String ruleName;
    private final String severity;
    private final String message;

    public SecurityAlert(
            String ruleName,
            String severity,
            String message) {

        this.ruleName = ruleName;
        this.severity = severity;
        this.message = message;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {

        return "ALERT"
                + "\nRule: " + ruleName
                + "\nSeverity: " + severity
                + "\nMessage: " + message;
    }
}