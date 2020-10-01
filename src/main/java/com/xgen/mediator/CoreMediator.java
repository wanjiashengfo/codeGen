package com.xgen.mediator;

import com.xgen.genconf.GenConfFactory;
import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.implementors.xmlimpl.GenConfXmlImpl;
import com.xgen.genconf.vo.ModuleConfModel;

import java.util.Collection;

/**
 * 核心框架的中介者对象
 */
public class CoreMediator {
    //实现成为单例
    private static CoreMediator mediator = new CoreMediator();
    private CoreMediator(){

    }

    public static CoreMediator getInstance(){
        return mediator;
    }
    public GenConfImplementor getDefaultGenConfProvider(){
        return new GenConfXmlImpl();
    }
    public Collection<ModuleConfModel> genNeedGenModuleConf(GenConfImplementor provider){
        return  GenConfFactory.createGernConfEbi(provider).getMapModuleConf().values();
    }
}