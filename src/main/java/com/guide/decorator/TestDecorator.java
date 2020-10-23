package com.guide.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        Audi audi = new Audi();
        DecoratorAudiRed decoratorAudiRed = new DecoratorAudiRed();
        decoratorAudiRed.setCarParent(audi);
        DecoratorAudiPurple decoratorAudiPurple = new DecoratorAudiPurple();
        decoratorAudiPurple.setCarParent(decoratorAudiRed);
        decoratorAudiPurple.printFace();
    }
}
