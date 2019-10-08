package io.hieulam.betest.repository;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.Shape;
import io.hieulam.betest.model.ShapeCategory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ShapeRepositoryImpl implements ShapeRepository {

    private List<ShapeCategory> shapeCategories;

    enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE};

    private Map<UUID, Shape> savedShapes;

    public ShapeRepositoryImpl() {
        shapeCategories = new ArrayList<>();
        savedShapes = new HashMap<>();

        insertDefaultCategory(shapeCategories);
    }

    private void insertDefaultCategory(List<ShapeCategory> shapeCategories) {

        ShapeCategory category = new ShapeCategory();
        category.setName("TRIANGLE");

        Attribute attribute1 = new Attribute("size1", "cm");
        Attribute attribute2 = new Attribute("size2", "cm");
        Attribute attribute3 = new Attribute("size3", "cm");

        List<Attribute> attributes = Arrays.asList(attribute1, attribute2, attribute3);

        category.setRequirements(attributes);

        shapeCategories.add(category);


    }


    @Override
    public List<ShapeCategory> getAllShapeCategories() {
        return this.shapeCategories;
    }

//    @Override
//    public Shape createShape() {
//        return null;
//    }

    @Override
    public Shape saveShape(Shape shape) {
        UUID newId = UUID.randomUUID();

        savedShapes.put(newId, shape);
        return shape;
    }

    @Override
    public List<Shape> getShapes() {
        return savedShapes.values().stream().collect(Collectors.toList());
    }
}
