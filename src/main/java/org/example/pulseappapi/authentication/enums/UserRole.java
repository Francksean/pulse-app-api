package org.example.pulseappapi.authentication.enums;

public enum UserRole {
    ADMIN("admin"),
    USER_PERSONAL("user"),
    USER_CENTER("center");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }

}
