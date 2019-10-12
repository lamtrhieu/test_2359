package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;

public class Rhombus extends Shape {

    @Override
    public long calculateArea() {
        long p = getAttributeValue("p");
        long q = getAttributeValue("q");

        this.area = p*q/2;

        return this.area;
    }

    @Override
    public String getCategory() {
        return Category.RHOMBUS.toString();
    }

    @Override
    public List<String> getOtherCategories() {
        return Arrays.asList(Category.PARALLELOGRAM.toString());
    }

    @Override
    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("p", "cm"), new Attribute("q", "cm"));
        return requirements;
    }
}
