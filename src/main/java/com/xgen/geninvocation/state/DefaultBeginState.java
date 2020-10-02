package com.xgen.geninvocation.state;

import com.xgen.geninvocation.DefaultGenInvocation;

public class DefaultBeginState implements State{
    @Override
    public void doWork(DefaultGenInvocation ctx) {
        //这里不去实现真正的功能 只是去用来设置第一个state
        ctx.setState(new GenState());
        ctx.doWork();
    }
}
