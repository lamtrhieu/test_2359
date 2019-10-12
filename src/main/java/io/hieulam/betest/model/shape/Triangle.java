package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Triangle extends Shape {

    protected Category category = Category.TRIANGLE;

    @Override
    public String getCategory() {
        return Category.TRIANGLE.toString();
    }

    @Override
    public String draw() {
        this.shapeURL = "http://service.com/triangle/" + UUID.randomUUID();

        return this.shapeURL;
    }

    @Override
    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("size", "cm"));
        return requirements;
    }

    @Override
    public long calculateArea() {
        long base = getAttributeValue("base");
        long height = getAttributeValue("height");
        this.area = (base*height)/2;

        return this.area;
    }
}
