package io.hieulam.betest.repository;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.shape.Rectangle;
import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.shape.Square;
import io.hieulam.betest.model.shape.Triangle;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ShapeRepositoryImpl implements ShapeRepository {

    private List<ShapeCategory> shapeCategories;

//    enum Category {TRIANGLE, SQUARE, RECTANGLE, PARALLELOGRAM, RHOMBUS, KITE, TRAPEZIUM, CIRCLE, ELLIPSE};

    private Map<UUID, Shape> savedShapes;

    public ShapeRepositoryImpl() {
        shapeCategories = new ArrayList<>();
        savedShapes = new HashMap<>();

//        insertDefaultCategory(shapeCategories);
    }

//    private void insertDefaultCategory(List<ShapeCategory> shapeCategories) {
//
//        ShapeCategory category = new ShapeCategory();
//        category.setName("TRIANGLE");
//
//        Attribute attribute1 = new Attribute("size1", "cm");
//        Attribute attribute2 = new Attribute("size2", "cm");
//        Attribute attribute3 = new Attribute("size3", "cm");
//
//        List<Attribute> attributes = Arrays.asList(attribute1, attribute2, attribute3);
//
//        category.setRequirements(attributes);
//
//        shapeCategories.add(category);
//
//        ShapeCategory eclipse = new ShapeCategory();
//        //List<Attribute> attributes
//
//        List<Shape> allShapes = new ArrayList<>();
//
////        Map<String, Shape> shapeMap = new HashMap<>();
////        shapeMap.put(Rectangle, )
//
//
//
//    }
//
//    public void test() {
//        List<Shape> allShapes = Arrays.asList(new Triangle(), new Rectangle(), new Square());
//
//        allShapes.stream().map(this::toShapeCategory).collect(Collectors.toList());
//    }




    @Override
    public List<ShapeCategory> getAllShapeCategories() {
        return this.shapeCategories;
    }

    @Override
    public Shape saveShape(Shape shape) {
        UUID newId = UUID.randomUUID();
        shape.setId(newId);

        savedShapes.put(newId, shape);

        return shape;
    }

    @Override
    public List<Shape> getShapes() {
        return savedShapes.values().stream().collect(Collectors.toList());
    }
}
