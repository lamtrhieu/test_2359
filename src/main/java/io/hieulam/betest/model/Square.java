package io.hieulam.betest.model;

import java.net.URI;
import java.util.UUID;

public class Square extends Shape {

    public String draw() {
        String url = "http://service.com/square" + UUID.randomUUID();
        setShapeURL(url);

        return url;
    }

    public long getArea() {
        long size = getAttributeValue("size");
        long area = size*size;
        setArea(area);

        return area;
    }

}
