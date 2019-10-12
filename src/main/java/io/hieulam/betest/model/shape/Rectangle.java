package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Rectangle extends Shape {

    @Override
    public long calculateArea() {
        long width = getAttributeValue("width");
        long length = getAttributeValue("length");

        this.area = width*length;

        return this.area;
    }

    @Override
    public String getCategory() {
        return Category.RECTANGLE.toString();
    }

    @Override
    public List<String> getOtherCategories() {
        return Arrays.asList(Category.PARALLELOGRAM.toString(), Category.RHOMBUS.toString());
    }

    @Override
    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("width", "cm"), new Attribute("length", "cm"));
        return requirements;
    }

}
