package com.guide.decorator;

public class DecoratorAudiRed extends DecoratorParent{
    @Override
    public void printFace() {
        super.printFace();
        System.out.println("给奥迪喷涂颜色为：红色火焰");
    }
}
