package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;

public class Parallelogram extends Shape {

    @Override
    public long calculateArea() {
        long base = getAttributeValue("base");
        long height = getAttributeValue("height");

        this.area = base*height;

        return this.area;
    }

    @Override
    public String getCategory() {
        return Category.PARALLELOGRAM.toString();
    }

    @Override
    public List<String> getOtherCategories() {
        return Arrays.asList();
    }

    @Override
    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("base", "cm"), new Attribute("height", "cm"));
        return requirements;
    }
}
