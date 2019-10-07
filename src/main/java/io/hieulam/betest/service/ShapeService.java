package io.hieulam.betest.service;

import io.hieulam.betest.model.Shape;
import io.hieulam.betest.model.ShapeCategory;

import java.util.List;

public interface ShapeService {
    List<ShapeCategory> listShapeCategories();
    Shape submitShape();
    Shape saveShape();
    Shape listSaveShapes();

}
