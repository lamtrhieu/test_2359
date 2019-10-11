package io.hieulam.betest.repository;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.shape.Rectangle;
import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.model.shape.Square;
import io.hieulam.betest.model.shape.Triangle;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ShapeRepositoryImpl implements ShapeRepository {

    private List<ShapeCategory> shapeCategories;

    private Map<UUID, Shape> savedShapes;

    public ShapeRepositoryImpl() {
        shapeCategories = new ArrayList<>();
        savedShapes = new HashMap<>();

        shapeCategories = insertDefaultShapeCategories();
    }

    public List<ShapeCategory> insertDefaultShapeCategories() {
        List<Shape> allShapes = Arrays.asList(new Triangle(), new Rectangle(), new Square());

        return allShapes.stream().map(this::toShapeCategory).collect(Collectors.toList());
    }

    private ShapeCategory toShapeCategory(Shape shape) {
        String category = shape.getCategory();
        List<Attribute> requirements = shape.getRequirements();

        return new ShapeCategory(category, requirements);
    }

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

    @Override
    public void addShapeCategory(ShapeCategory shapeCategory) {
        shapeCategories.add(shapeCategory);
    }

}
