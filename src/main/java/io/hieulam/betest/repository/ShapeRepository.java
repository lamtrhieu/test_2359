package io.hieulam.betest.repository;

import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.Shape;

import java.util.List;

public interface ShapeRepository {
    public List<ShapeCategory> getAllShapeCategories();
    public Shape createShape();
    public Shape saveShape();
    public List<Shape> getShapes();
}
