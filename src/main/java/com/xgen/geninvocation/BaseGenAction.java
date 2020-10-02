package com.xgen.geninvocation;

import com.xgen.genconf.vo.ModuleConfModel;

public abstract class BaseGenAction {
    /**
     * 模板方法 用来执行每个具体功能generate过程
     * @param moduleConf
     * @return
     */
    public Object generate(ModuleConfModel moduleConf){
        //1.得到用来封装generate内容对象
        Object obj = initObject();

        //2.执行具体generate之前要执行的功能
        beforeAction(moduleConf);
        //3.执行action的功能
        obj = execute(moduleConf,obj);
        //4.执行具体generate之后要执行的功能
        afterAction(moduleConf);
        return obj;
    }

    /**
     * 源于操作 初始化封装generate生成内容的对象
     * @return
     */
    public abstract Object initObject();

    /**
     * 钩子操作 在执行action之前要实现的功能
     * @param moduleConf
     */
    public void beforeAction(ModuleConfModel moduleConf){

    }
    /**
     * 钩子操作 在执行action之前要实现的功能
     * @param moduleConf
     */
    public void afterAction(ModuleConfModel moduleConf){

    }

    /**
     * 源语操作 执行action的generate方法
     * @param moduleConf
     * @param obj
     * @return
     */
    public abstract Object execute(ModuleConfModel moduleConf,Object obj);
}
