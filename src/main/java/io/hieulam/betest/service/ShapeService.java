package io.hieulam.betest.service;

import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.model.ShapeCategory;

import java.util.List;


public interface ShapeService {
    Shape submitShape(ShapeCategory request);
    Shape saveShape(Shape shape);
    List<Shape> listSaveShapes();
    void addShapeCategory(ShapeCategory shapeCategory);
    List<ShapeCategory> getAllShapeCategories();

    List<Shape> listSaveShapesForKid(String name);

    Shape createShapeForKid(String name, Shape shape);

    Shape updateShapeForKid(String name, Shape shape, String id);

    void deleteShapeForKid(String name, String id);
}
