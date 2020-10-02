package com.xgen.genproxy;

import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.geninvocation.GenInvocation;
import com.xgen.geninvocation.GenInvocationFactory;
import com.xgen.mediator.CoreMediator;

public class GenProxyFactory {
    private GenProxyFactory(){

    }

    public static GenInvocation createGenProxy(String needGenType, ModuleConfModel moduleConf){
        //创建真正执行generate的对象，也就是被代理的对象 现在是默认使用本地的
        GenInvocation invocation = CoreMediator.getInstance().getDefaultGenInvocation(needGenType,moduleConf);
        //创建代理对象
        return new DefaultProxy(invocation);
    }
}
