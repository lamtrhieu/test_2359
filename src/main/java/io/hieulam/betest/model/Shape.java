package io.hieulam.betest.model;

import java.util.List;

public class Shape {

    protected List<Attribute> attributes;
    protected long area;
    protected String shapeURL;

    public String getShapeURL() {
        return shapeURL;
    }

    public void setShapeURL(String shapeURL) {
        this.shapeURL = shapeURL;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String draw() {
        return null;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    protected long getAttributeValue(String name) {
        long result = 0;
        for (Attribute attribute : attributes) {
            if (attribute.getName().equals(name)) {
                result = Long.parseLong(attribute.getValue());
                break;
            }
        }
        return result;
    }

}

