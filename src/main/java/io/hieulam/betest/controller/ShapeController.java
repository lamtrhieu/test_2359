package io.hieulam.betest.controller;

import io.hieulam.betest.model.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.ShapeRequest;
import io.hieulam.betest.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShapeController {

    @Autowired
    ShapeService shapeService;

    @RequestMapping(
            value = "/shapes/categories",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<ShapeCategory> listShapeCategories() {
        System.out.println( "I will get all the shape categories here");
        return shapeService.listShapeCategories();
    }

    @RequestMapping(value = "/shapes/submit", method = RequestMethod.GET)
    @ResponseBody
    public Shape submitShape(@RequestBody ShapeRequest shapeRequest) {
        Shape shape = shapeService.submitShape(shapeRequest);
        return shape;
    }

    @RequestMapping("/shapes")
    Shape saveShape() {
        System.out.println("I will save the shape here.");
        return null;
    }

    @RequestMapping("/shapes/saveShapes")
    Shape listSaveShapes() {
        System.out.println("I will list all the save shape.");
        return null;
    }
}
