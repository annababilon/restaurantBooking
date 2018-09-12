package com.blackbytes.springbootexample.restaurant;

public enum PriceLevel {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    VERY_HIGH("VERY HIGH"),
    NO_INFO("NO INFO");


    private String name;

    PriceLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}