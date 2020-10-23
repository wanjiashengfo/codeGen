package com.guide.state;
//具体状态子类Mad 实现一个与person的状态相关的行为
public class Mad implements MoodState{
    Person p;
    public Mad(Person p){
        this.p = p;
    }
    @Override
    public void doSomething() {
        System.out.println("I'm mad!");
    }

    @Override
    public void changeState() {
        p.setState(new Angry(p));
    }
}
