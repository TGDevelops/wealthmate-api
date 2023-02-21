package com.tgdevelops.wealthmate.models;

public class Investment {
    private String id;
    private String type;
    private String name;
    private int value;
    private int year;
    private int expectedROI;

    public Investment() {}

    public Investment(String id, String type, String name, int value, int year, int expectedROI) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.value = value;
        this.year = year;
        this.expectedROI = expectedROI;
    }

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getExpectedROI() {
        return expectedROI;
    }

    public void setExpectedROI(int expectedROI) {
        this.expectedROI = expectedROI;
    }
}

