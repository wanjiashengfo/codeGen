package com.guide.strategy;

public class TestStrategy {
    public static void main(String[] args) {
        Strategy stgA = new ConcreteStrategyA();
        Context ct = new Context(stgA);
        ct.DoAction();
    }
}
