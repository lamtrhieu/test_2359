package io.hieulam.betest.controller;

import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.ShapeRequest;
import io.hieulam.betest.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1")
public class ShapeController {

    @Autowired
    ShapeService shapeService;

    @RequestMapping(
            value = "/shapes/categories",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<ShapeCategory> listShapeCategories() {
        return Shape.getAllShapeCategories();
    }

    @RequestMapping(value = "/shapes/submit", method = RequestMethod.GET)
    @ResponseBody
    public Shape submitShape(@RequestBody ShapeRequest shapeRequest) {
        Shape shape = shapeService.submitShape(shapeRequest);
        return shape;
    }

    @RequestMapping(value = "/shapes", method = RequestMethod.POST)
    @ResponseBody
    public Shape saveShape(@RequestBody Shape shape) {
        Shape savedShape = shapeService.saveShape(shape);
        return savedShape;
    }

    @RequestMapping(value = "/shapes/saved-shapes", method = RequestMethod.GET)
    @ResponseBody
    public List<Shape> listSaveShapes() {
        return shapeService.listSaveShapes();
    }
}
