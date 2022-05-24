package com.sample.springbootsampleapp.model;

public enum StudentType {
    UNDERGRADUATE("Undergraduate"),
    GRADUATE("graduate"),
    EXCHANGE("Exchange");

    private String value;

    StudentType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
