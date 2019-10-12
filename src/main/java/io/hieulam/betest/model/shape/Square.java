package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;

import java.util.Arrays;
import java.util.List;

public class Square extends Shape {

    @Override
    public String getCategory() {
        return Category.SQUARE.toString();
    }

    @Override
    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("base", "cm"), new Attribute("high", "cm"), new Attribute("angle", "degree"));
        return requirements;
    }

    @Override
    public long calculateArea() {
        long size = getAttributeValue("size");
        this.area = size*size;

        return area;
    }

    @Override
    public List<String> getOtherCategories() {
        return Arrays.asList(Category.PARALLELOGRAM.toString(), Category.RECTANGLE.toString(), Category.RHOMBUS.toString());
    }

}
