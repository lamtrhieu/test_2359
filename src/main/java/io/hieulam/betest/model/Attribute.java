package io.hieulam.betest.model;

public class Attribute {
    private String name;
    private String unit;
    private long value;

    public Attribute(String name, String unit, long value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public Attribute(String name, String unit) {
        this.name = name;
        this.unit = unit;
        this.value = 0;
    }


    public long getValue() {
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

    public void setValue(long value) {
        this.value = value;
    }
}
