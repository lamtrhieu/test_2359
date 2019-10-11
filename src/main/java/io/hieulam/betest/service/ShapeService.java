package io.hieulam.betest.service;

import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.ShapeRequest;

import java.util.List;


public interface ShapeService {
    Shape submitShape(ShapeRequest request);
    Shape saveShape(Shape shape);
    List<Shape> listSaveShapes();
    void addShapeCategory(ShapeCategory shapeCategory);
    List<ShapeCategory> getAllShapeCategories();
}
