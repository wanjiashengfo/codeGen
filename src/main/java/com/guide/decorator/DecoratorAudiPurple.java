package com.guide.decorator;

public class DecoratorAudiPurple extends DecoratorParent{
    @Override
    public void printFace() {
        super.printFace();
        System.out.println("给奥迪喷涂颜色为：紫色霞光");
    }
}
