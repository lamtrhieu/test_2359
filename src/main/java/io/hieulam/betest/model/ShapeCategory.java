package io.hieulam.betest.model;

import java.util.List;
import java.util.Locale;

public class ShapeCategory {
    String name;
    String type;
    List<Attribute> requirements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Attribute> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Attribute> requirements) {
        this.requirements = requirements;
    }
//enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE};


//    public void test() {
//        ShapeCategory shapeCategory = new ShapeCategory();
//        shapeCategory.type = Locale.Category.TRIANGLE;
//
//    }

}