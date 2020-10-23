package com.guide.builder;

public class Test {
    public static void main(String[] args) {
        ConcreateBuilder builder = new ConcreateBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
    }
}
