package io.hieulam.betest.model;

import java.util.List;
import java.util.UUID;

public class Rectangle extends Shape {

    public String draw() {
        String url = "http://service.com/square" + UUID.randomUUID();
        setShapeURL(url);

        return url;
    }

    public long getArea() {
        long width = getAttributeValue("size");
        long length = getAttributeValue("length");

        return width*length;
    }

}
