package io.hieulam.betest.controller;

import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.ShapeRequest;
import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1")
public class ShapeController {

    @Autowired
    ShapeService shapeService;

    @GetMapping("/shapes/categories")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<ShapeCategory> listShapeCategories() {
        return shapeService.getAllShapeCategories();
    }

    @GetMapping("/shapes/submit")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public Shape submitShape(@RequestBody ShapeRequest shapeRequest) {
        Shape shape = shapeService.submitShape(shapeRequest);
        return shape;
    }

    @PostMapping("/shapes")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public Shape saveShape(@RequestBody Shape shape) {
        Shape savedShape = shapeService.saveShape(shape);
        return savedShape;
    }

    @GetMapping("/shapes/saved-shapes")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Shape> listSaveShapes() {
        return shapeService.listSaveShapes();
    }

    @PostMapping("/shapes/categories")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addShapeCategory(@RequestBody ShapeCategory shapeCategory) {
        shapeService.addShapeCategory(shapeCategory);
    }
}
