package org.example.pulseappapi.donation.enums;

public enum AppointmentStatus {
    SCHEDULED("scheduled"),
    DONE("done"),
    CANCELLED("cancelled");

    private final String value;

    private AppointmentStatus(String value) {
        this.value = value;
    }

    public static AppointmentStatus fromString(String text) {
        for (AppointmentStatus type : AppointmentStatus.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid appointment status type: " + text);
    }
}
