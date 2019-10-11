package io.hieulam.betest.service;

import io.hieulam.betest.model.*;
import io.hieulam.betest.model.shape.Rectangle;
import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.model.shape.Square;
import io.hieulam.betest.model.shape.Triangle;
import io.hieulam.betest.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {

    @Autowired
    ShapeRepository shapeRepository;

    @Override
    public List<ShapeCategory> listShapeCategories() {
        return shapeRepository.getAllShapeCategories();
    }

    @Override
    public Shape submitShape(ShapeRequest request) {
        Shape shape = createShapeFromType(request.getCategory());
        shape.setAttributes(request.getRequirements());

        shape.draw();
        shape.getArea();

        return shape;
    }

    private Shape createShapeFromType(String category) {
        Shape result = null;

        Shape.Category enumCategory = Shape.Category.valueOf(category);

        switch (enumCategory) {
            case TRIANGLE:
                result = new Triangle();
                break;
            case SQUARE:
                result = new Square();
                break;
            case RECTANGLE:
                result = new Rectangle();
                break;

        }

        return result;
    }

    @Override
    public Shape saveShape(Shape shape) {
        Shape savedShape = shapeRepository.saveShape(shape);
        return savedShape;
    }

    @Override
    public List<Shape> listSaveShapes() {
        return shapeRepository.getShapes();
    }

    @Override
    public void addShapeCategory(ShapeCategory shapeCategory) {
        shapeRepository.addShapeCategory(shapeCategory);
    }

    @Override
    public List<ShapeCategory> getAllShapeCategories() {
        return shapeRepository.getAllShapeCategories();
    }
}
