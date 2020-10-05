package com.xgen.geninvocation.state;

import com.xgen.geninvocation.DefaultGenInvocation;
import com.xgen.mediator.CoreMediator;
import com.xgen.template.DefaultTemplateEbo;

public class OutState implements State{
    @Override
    public void doWork(DefaultGenInvocation ctx) {
        //把内容输出出去

        //1.注册观察者 需要把需要输出的类型当成观察者 并注册到obserable里面
//        CoreMediator.getInstance().registerObservers(ctx);
//        //2.通知观察者
//        ctx.setContentOver(ctx.getTempContent());
//        //设置后续state
        System.out.println("over content===="+((DefaultTemplateEbo)ctx.getTempContent()).getNowContent());
    }
}
