package com.masai.app.model;

public enum GenderType {

        MALE("Male"),
        FEMALE("Female"),
        NON_BINARY("Non-binary"),
        UNKNOWN("Unknown");

        private final String name;

    GenderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
