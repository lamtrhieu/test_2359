package io.hieulam.betest.model;

import java.util.List;

public class ShapeRequest {
    private String category;
    private List<Attribute> requirements;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Attribute> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Attribute> requirements) {
        this.requirements = requirements;
    }
}
