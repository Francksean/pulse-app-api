package org.example.pulseappapi.authentication.enums;

public enum GenderType {
    H_GENDER("H"),
    F_GENDER("F");

    private final String value;

    GenderType(String s) {
        this.value = s;
    }

    public static GenderType fromString(String text) {
        for (GenderType type : GenderType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid gender type: " + text);
    }
}
