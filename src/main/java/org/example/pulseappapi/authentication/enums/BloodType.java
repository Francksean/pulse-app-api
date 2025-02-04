package org.example.pulseappapi.authentication.enums;

public enum BloodType {
    A_POS("A+"),
    A_NEG("A-"),
    B_POS("B+"),
    B_NEG("B-"),
    AB_POS("AB+"),
    AB_NEG("AB-"),
    O_POS("O+"),
    O_NEG("O-");

    private final String value;

    BloodType(String s) {
        this.value = s;
    }

    public static BloodType fromString(String text) {
        for (BloodType type : BloodType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid blood type: " + text);
    }
}
