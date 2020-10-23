package com.guide.mediator;

public class TestMediator {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        new Producer(mediator).start();
        new Producer(mediator).start();

        new Consumer(mediator).start();
        new Consumer(mediator).start();
        new Consumer(mediator).start();
        new Consumer(mediator).start();
    }
}
