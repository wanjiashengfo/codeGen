package com.guide.state;
//定义一个接口以封装与person的一个特定状态相关的行为
public interface MoodState {
    public void doSomething();
    public void changeState();
}
