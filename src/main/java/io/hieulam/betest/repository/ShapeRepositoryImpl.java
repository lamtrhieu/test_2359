package io.hieulam.betest.repository;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.service.ShapeService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ShapeRepositoryImpl implements ShapeRepository {

    private List<ShapeCategory> shapeCategories;

    enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE};

    public ShapeRepositoryImpl() {
        shapeCategories = new ArrayList<>();

        insertDefaultCategory(shapeCategories);
    }

    private void insertDefaultCategory(List<ShapeCategory> shapeCategories) {

        ShapeCategory category = new ShapeCategory();
        category.setName("TRIANGLE");
        category.setType("TRIANGLE");

        Attribute attribute1 = new Attribute("size1", "cm", "0");
        Attribute attribute2 = new Attribute("size2", "cm", "0");
        Attribute attribute3 = new Attribute("size3", "cm", "0");

        List<Attribute> attributes = Arrays.asList(attribute1, attribute2, attribute3);

        category.setRequirements(attributes);

        shapeCategories.add(category);


    }


    @Override
    public List<ShapeCategory> getAllShapeCategories() {
        return this.shapeCategories;
    }

    @Override
    public Shape createShape() {
        return null;
    }

    @Override
    public Shape saveShape() {
        return null;
    }

    @Override
    public List<Shape> getShapes() {
        return null;
    }
}
