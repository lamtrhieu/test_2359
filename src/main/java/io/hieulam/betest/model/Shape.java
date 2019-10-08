package io.hieulam.betest.model;

import java.util.List;

public class Shape {

    public void setArea(long area) {
        this.area = area;
    }

    public String getShapeURL() {
        return shapeURL;
    }

    public void setShapeURL(String shapeURL) {
        this.shapeURL = shapeURL;
    }

    private long area;

    private String shapeURL;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    protected List<Attribute> attributes;

    public String draw() {
        return null;
    }

    public long getArea() {
        return 0;
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



//    String draw();
//    long getArea();
//    List<ShapeCategory> getShapeCategories();
}

