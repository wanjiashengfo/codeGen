package com.guide.decorator;

import lombok.Setter;

public abstract class DecoratorParent extends CarParent{
    @Setter
    protected CarParent carParent;
    @Override
    public void printFace() {
        carParent.printFace();
    }
}
