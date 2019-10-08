package io.hieulam.betest.repository;

import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.shape.Shape;

import java.util.List;

public interface ShapeRepository {
    List<ShapeCategory> getAllShapeCategories();
    //Shape createShape();
    Shape saveShape(Shape shape);
    List<Shape> getShapes();
}
