package io.hieulam.betest.model.shape;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.shape.Shape;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Square extends Shape {


    public String draw() {
        String url = "http://service.com/square" + UUID.randomUUID();
        setShapeURL(url);

        return url;
    }

    public String getCategory() {
        return Category.SQUARE.toString();
    }

    public List<Attribute> getRequirements() {
        List<Attribute> requirements = Arrays.asList(new Attribute("base", "cm"), new Attribute("high", "cm"), new Attribute("angle", "degree"));
        return requirements;
    }

    public long getArea() {
        long size = getAttributeValue("size");
        long area = size*size;
        setArea(area);

        return area;
    }

}
