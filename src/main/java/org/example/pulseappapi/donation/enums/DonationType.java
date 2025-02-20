package org.example.pulseappapi.donation.enums;

public enum DonationType {
    ALERT("alert"),
    CAMPAIGN("campaign"),
    SPONTANEOUS("spontaneous");

    private final String value;

    private DonationType(String value) {
        this.value = value;
    }

    public static DonationType fromString(String text) {
        for (DonationType type : DonationType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid appointment status type: " + text);
    }
}
