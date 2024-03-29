package io.hieulam.betest.service;

import io.hieulam.betest.model.*;
import io.hieulam.betest.model.shape.*;
import io.hieulam.betest.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {

    @Autowired
    ShapeRepository shapeRepository;

    public ShapeServiceImpl(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    @Override
    public Shape submitShape(ShapeCategory request) {
        String shapeCategory = request.getName();

        if (!shapeRepository.isShapeCategoryExist(shapeCategory)) {
            throw new RuntimeException("Invalid Shape Category");
        }

        Shape shape = createShapeFromType(request.getName());
        shape.setShapeCategory(request);

        shape.draw();
        shape.calculateArea();

        return shape;
    }

    private Shape createShapeFromType(String category) {
        Shape result = null;

        switch (category) {
            case "TRIANGLE":
                result = new Triangle();
                break;
            case "SQUARE":
                result = new Square();
                break;
            case "RECTANGLE":
                result = new Rectangle();
                break;
            default:
                result = new CustomShape();
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

    @Override
    public List<Shape> listSaveShapesForKid(String name) {
        return shapeRepository.selectSaveShapesForKid(name);
    }

    @Override
    public Shape createShapeForKid(String name, Shape shape) {
        return shapeRepository.insertShapeForKid(name, shape);
    }

    @Override
    public Shape updateShapeForKid(String name, Shape shape, String id) {
        return shapeRepository.updateShapeForKid(name, shape, id);
    }

    @Override
    public void deleteShapeForKid(String name, String id) {
        shapeRepository.deleteShapeForKid(name, id);
    }
}
