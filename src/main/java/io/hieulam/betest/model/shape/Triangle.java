package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.shape.Shape;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Triangle extends Shape {

    protected Category category = Category.TRIANGLE;

    public String getCategory() {
        return Category.TRIANGLE.toString();
    }

    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("size", "cm"));
        return requirements;
    }


    public long getArea() {
        long width = getAttributeValue("size");
        long length = getAttributeValue("length");

        return width*length;
    }
}
