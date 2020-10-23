package com.guide.state;
//具体状态子类Angry 实现一个与person的状态相关的行为
public class Angry implements MoodState{
    Person p;
    public Angry(Person p){
        this.p = p;
    }
    @Override
    public void doSomething() {
        System.out.println("I'm angry!");
    }

    @Override
    public void changeState() {
        p.setState(new Happy(p));
    }
}
