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

    Map<String, ShapeCategory> shapeCategories;

    private Map<UUID, Shape> savedShapes;

    public ShapeRepositoryImpl() {
        shapeCategories = new HashMap<>();
        savedShapes = new HashMap<>();

        insertDefaultShapeCategories();
    }

    private void insertDefaultShapeCategories() {
        List<Shape> allShapes = Arrays.asList(new Triangle(), new Rectangle(), new Square());

        for (Shape shape : allShapes) {
            ShapeCategory category = toShapeCategory(shape);
            shapeCategories.put(shape.getCategory(), category);
        }

    }

    private ShapeCategory toShapeCategory(Shape shape) {
        String category = shape.getCategory();
        List<Attribute> requirements = shape.getRequirements();

        return new ShapeCategory(category, requirements);
    }

    @Override
    public List<ShapeCategory> getAllShapeCategories() {
        return this.shapeCategories.values().stream().collect(Collectors.toList());
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
        shapeCategories.put(shapeCategory.getName(), shapeCategory);
    }

    @Override
    public boolean isShapeCategoryExist(String category) {
        return shapeCategories.containsKey(category);
    }

    @Override
    public List<Shape> selectSaveShapesForKid(String name) {
        return savedShapes.values().stream().filter(shape -> shape.getOwner().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Shape insertShapeForKid(String name, Shape shape) {
        UUID newId = UUID.randomUUID();
        shape.setId(newId);
        shape.setOwner(name);

        savedShapes.put(newId, shape);
        return shape;
    }

    @Override
    public Shape updateShapeForKid(String name, Shape newShape, String id) {
        UUID key = UUID.fromString(id);
        Shape shape  = savedShapes.get(key);

        if (shape == null) {
            throw new RuntimeException("Cannot update shape with id: " + id);
        } else if (!shape.getOwner().equals(name)) {
            throw new RuntimeException("Cannot update shape from other owner.");
        }
        newShape.setOwner(name);
        savedShapes.put(key, newShape);
        return  newShape;
    }

    @Override
    public void deleteShapeForKid(String name, String id) {
        UUID key = UUID.fromString(id);
        Shape shape = savedShapes.get(key);

        if (shape == null) {
            throw new RuntimeException("Cannot find shape with id: " + id);
        } else if (!shape.getOwner().equals(name)) {
            throw new RuntimeException("Cannot delete shape from other owner.");
        }

        savedShapes.remove(key);
    }

}
