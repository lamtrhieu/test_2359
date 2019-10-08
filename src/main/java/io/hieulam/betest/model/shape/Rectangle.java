package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;

public class Rectangle extends Shape {

    public long getArea() {
        long width = getAttributeValue("size");
        long length = getAttributeValue("length");

        return width * length;
    }

    public String getCategory() {
        return Category.RECTANGLE.toString();
    }


    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("width", "cm"), new Attribute("length", "cm"));
        return requirements;
    }

}
