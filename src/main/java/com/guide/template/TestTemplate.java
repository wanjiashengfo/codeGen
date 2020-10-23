package com.guide.template;

import java.util.ArrayList;
import java.util.List;

public class TestTemplate {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle());
        shapeList.add(new Square());
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}
