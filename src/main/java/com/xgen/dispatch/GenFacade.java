package com.xgen.dispatch;

import com.xgen.genconf.GenConfFactory;
import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.mediator.CoreMediator;

import java.util.Collection;
import java.util.List;

public class GenFacade{
    /**
     * 防止客户端无谓的创建实例
     */
    private GenFacade(){

    }

    /**
     * 提供给外部使用的方法 客户端通过这个方法来请求生成器运行
     * 生成所需要的配置数据按照默认的配置来
     */
    public static void generate() {
        generate(CoreMediator.getInstance().getDefaultGenConfProvider());
    }

    /**
     * 提供给外部使用的方法 客户端通过这个方法来请求生成器运行
     * 生成所需要的数据按照传入的获取配置数据的实现中获得
     * @param provider
     */
    public static void generate(GenConfImplementor provider) {
        //循环生成在核心框架配置里面的需要生成的模块

        for (ModuleConfModel mcm : CoreMediator.getInstance().genNeedGenModuleConf(provider)) {
            //具体生成每一个模块
            genOneModule(mcm);
        }
    }

    /**
     * 具体去生成每一个模块
     * @param mcm
     */
    private static void genOneModule(ModuleConfModel mcm){

    }
}
