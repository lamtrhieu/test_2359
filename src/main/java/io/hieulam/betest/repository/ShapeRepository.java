package io.hieulam.betest.repository;

import io.hieulam.betest.model.Category;
import io.hieulam.betest.model.Shape;

import java.util.List;

public interface ShapeRepository {
    public List<Category> getAllShapeCategories();
    public Shape createShape();
    public Shape saveShape();
    public List<Shape> getShapes();
}
