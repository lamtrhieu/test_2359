package io.hieulam.betest.model.shape;

import java.util.UUID;

public class CustomShape extends Shape {

    public String getCategory() {
        return shapeCategory.getName();
    }


    public String draw() {
        String url = "http://service.com/" + getCategory() + UUID.randomUUID();
        setShapeURL(url);

        return url;
    }

    public long calculateArea() {
        String formula = getShapeCategory().getAreaFormula();
        //Using a expression evaluator like this one http://mathparser.org/ to calculate;
        //We already have the formula so just need to input the expression variable values from Shape.category.requirements
        //So the code should look like
        //Expression expr = (a + b)*sin(c)*0.25
        //Map<String, Integer> variables = new HashMap<>();
        //Map.put(a, 3)
        //Map.put(b, 4)
        //Map.put(c, 15)
        //area = expr.eval();

        return area;
    }
}
