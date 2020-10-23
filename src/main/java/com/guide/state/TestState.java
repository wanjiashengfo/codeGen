package com.guide.state;

public class TestState {
    public static void main(String[] args) {
        Person person = new Person();
        for(int i = 0;i < 3;i++){
            person.doSomething();
        }
    }
}
