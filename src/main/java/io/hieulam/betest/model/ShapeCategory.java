package io.hieulam.betest.model;

import java.util.List;

public class ShapeCategory {
    String name;
    Category type;
    List<Attribute> requirements;


    enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE};


    public void test() {
        ShapeCategory shapeCategory = new ShapeCategory();
        shapeCategory.type = Category.TRIANGLE;

    }
}