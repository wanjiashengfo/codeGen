package com.guide.state;

import lombok.Data;

//状态管理器 将与状态相关的请求委托给当前的具体状态子类对象来处理
@Data
public class Person {
    private MoodState state;
    public Person(){
        this.state = new Mad(this);
    }
    public void doSomething(){
        state.doSomething();
        state.changeState();
    }
}
