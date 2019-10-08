package io.hieulam.betest.service;

import io.hieulam.betest.model.*;
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

    private Shape createShapeFromType(String type) {
        Shape shape = null;
        if ("TRIANGLE".equals(type)) {
            shape = new Square();

        } else if ("SQUARE".equals(type)) {
            shape = new Rectangle();
        }

        return shape;
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
}
