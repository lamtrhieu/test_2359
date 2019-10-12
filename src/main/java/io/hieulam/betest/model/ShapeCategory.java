package io.hieulam.betest.model;

import java.util.List;

public class ShapeCategory {
    List<Attribute> requirements;
    private String name;
    private String areaFormula;

    public ShapeCategory(String category, List<Attribute> requirements) {
        this.name = category;
        this.requirements = requirements;

    }

    public String getAreaFormula() {
        return areaFormula;
    }

    public void setAreaFormula(String areaFormula) {
        this.areaFormula = areaFormula;
    }

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