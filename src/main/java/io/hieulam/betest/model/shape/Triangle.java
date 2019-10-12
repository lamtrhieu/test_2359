package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;

public class Triangle extends Shape {

    protected Category category = Category.TRIANGLE;

    @Override
    public String getCategory() {
        return Category.TRIANGLE.toString();
    }

    @Override
    public long calculateArea() {
        long base = getAttributeValue("base");
        long height = getAttributeValue("height");
        this.area = (base*height)/2;

        return this.area;
    }

    @Override
    public List<Attribute> getRequirements() {
        Attribute base = new Attribute("base", "cm");
        Attribute height = new Attribute("height", "cm");
        Attribute angle = new Attribute("angle", "degree");

        List<Attribute> requirements = Arrays.asList(base, height, angle);
        return requirements;
    }
}
