package io.hieulam.betest.model;

import java.util.List;

public interface Shape {
    void draw();
    long getArea();
    List<ShapeCategory> getCategories();
    List<Attribute> getRequirements();

}

