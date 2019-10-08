package io.hieulam.betest.model;

import java.util.List;
import java.util.Locale;

public class ShapeCategory {
    private String name;
    List<Attribute> requirements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Attribute> requirements) {
        this.requirements = requirements;
    }

}