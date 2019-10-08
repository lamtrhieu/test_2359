package io.hieulam.betest.model;

import java.util.List;

public class Triangle implements Shape {

    @Override
    public String draw() {
        return "This is the url for Triangle image";
    }

    @Override
    public long getArea() {

        return 0;
    }

    @Override
    public List<ShapeCategory> getCategories() {
        return null;
    }

    @Override
    public List<Attribute> getRequirements() {
        return null;
    }
}
