package io.hieulam.betest.controller;

import io.hieulam.betest.model.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    List<ShapeCategory> listShapeCategories() {
        System.out.println( "I will get all the shape categories here");
        return shapeService.listShapeCategories();
    }

    @RequestMapping(value = "/shapes/submit", method = RequestMethod.POST)
    Shape submitShape() {
        System.out.println("I will submit the shape here.");
        return null;
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
