package com.guide.facade;

public class Test {
    public static void main(String[] args) {
        Facade carFacade = new Facade();
        carFacade.car_go(new ACar());
    }
}
