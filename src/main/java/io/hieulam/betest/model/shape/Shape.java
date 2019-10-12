package io.hieulam.betest.model.shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.ShapeCategory;

import java.util.List;
import java.util.UUID;

public class Shape {

    protected long area;
    protected String shapeURL;
    protected UUID id;
    protected ShapeCategory shapeCategory;
    List<String> otherCategories;
    String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ShapeCategory getShapeCategory() {
        return shapeCategory;
    }

    public void setShapeCategory(ShapeCategory shapeCategory) {
        this.shapeCategory = shapeCategory;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getShapeURL() {
        return shapeURL;
    }

    public void setShapeURL(String shapeURL) {
        this.shapeURL = shapeURL;
    }

    public String draw() {
        this.shapeURL = "http://service.com/" + this.getCategory() + "/" + UUID.randomUUID();

        return this.shapeURL;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    protected long getAttributeValue(String name) {
        long result = 0;
        for (Attribute attribute : shapeCategory.getRequirements()) {
            if (attribute.getName().equals(name)) {
                result = Long.parseLong(attribute.getValue());
                break;
            }
        }
        return result;
    }

    public long calculateArea() {
        return 0;
    }

    //These methods need to be overriden in subclasses to provide correct data for each shape category.

    @JsonIgnore
    public List<Attribute> getRequirements() {
        return null;
    }

    public String getCategory() {
        return this.shapeCategory.getName();
    }

    public List<String> getOtherCategories() {
        return this.otherCategories;
    }

    public void setOtherCategories(List<String> otherCategories) {
        this.otherCategories = otherCategories;
    }

    public enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE}

}