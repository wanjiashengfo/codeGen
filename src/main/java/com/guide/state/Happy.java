package com.guide.state;
//具体状态子类Happy 实现一个与person的状态相关的行为
public class Happy implements MoodState{
    Person p;
    public Happy(Person p){
        this.p = p;
    }
    @Override
    public void doSomething() {
        System.out.println("I'm happy!");
    }

    @Override
    public void changeState() {
        p.setState(new Mad(p));
    }
}
