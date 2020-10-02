package com.xgen.geninvocation.state;

import com.xgen.geninvocation.DefaultGenInvocation;
import com.xgen.mediator.CoreMediator;

public class GenState implements State{
    @Override
    public void doWork(DefaultGenInvocation ctx) {
        //首先实现自己的业务功能
        //1.获取每个theme对应的action
        String className = CoreMediator.getInstance().getNeedGenTypeClass(ctx.getNeedGenType(),ctx.getModuleConf());
        //2.调用action来获得生成的内容
//        Class.forName(className).newInstance();
        //设置下一个state
        ctx.setState(new OutState());
        ctx.doWork();
    }
}