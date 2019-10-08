package io.hieulam.betest.model;

public class Attribute {
    private String name;
    private String unit;
    private String value;

    public Attribute() {

    }

    public Attribute(String name, String unit, String value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public Attribute(String name, String unit) {
        this.name = name;
        this.unit = unit;
        this.value = "0";
    }


    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
