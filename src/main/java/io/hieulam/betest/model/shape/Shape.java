package io.hieulam.betest.model.shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.ShapeCategory;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Shape {

    protected List<Attribute> attributes;
    protected long area;
    protected String shapeURL;
    protected UUID id;

    public enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE};

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

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String draw() {
        String url = "http://service.com/" + this.getCategory() + UUID.randomUUID();
        setShapeURL(url);

        return url;
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

    @JsonIgnore
    public List<Attribute> getRequirements() {
        return null;
    }

    public String getCategory() {
        return null;
    }

    public static List<ShapeCategory> getAllShapeCategories() {
        List<Shape> allShapes = Arrays.asList(new Triangle(), new Rectangle(), new Square());

        return allShapes.stream().map(Shape::toShapeCategory).collect(Collectors.toList());
    }

    private static ShapeCategory toShapeCategory(Shape shape) {
        String category = shape.getCategory();
        List<Attribute> requirements = shape.getRequirements();

        return new ShapeCategory(category, requirements);
    }

}

