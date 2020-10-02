package com.xgen.geninvocation;

import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.geninvocation.decorator.DefaultComponent;
import com.xgen.geninvocation.decorator.GenComponent;
import com.xgen.geninvocation.decorator.ReadTemplateContent;
import com.xgen.geninvocation.decorator.ReplaceProperty;

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
        Object before =  this.beforeAction(moduleConf);
        if(before != null){
            obj = this.executeDecorators(moduleConf,obj,(GenComponent)before);
        }
        //3.执行action的功能
        obj = execute(moduleConf,obj);
        //4.执行具体generate之后要执行的功能
        Object after =  this.afterAction(moduleConf);
        if(after != null){
            obj = this.executeDecorators(moduleConf,obj,(GenComponent)after);
        }
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
    public GenComponent beforeAction(ModuleConfModel moduleConf){
        return null;
    }
    /**
     * 钩子操作 在执行action之前要实现的功能
     * @param moduleConf
     */
    public GenComponent afterAction(ModuleConfModel moduleConf){
        return null;
    }

    /**
     * 源语操作 执行action的generate方法
     * @param moduleConf
     * @param obj
     * @return
     */
    public abstract Object execute(ModuleConfModel moduleConf,Object obj);

    /**
     * 执行action的装饰对象
     * @param moduleConf
     * @param obj
     * @param gc
     * @return
     */
    public abstract Object executeDecorators(ModuleConfModel moduleConf, Object obj, GenComponent gc);

    /**
     * 提供给子类的公共方法 缺省执行action操作前的装饰器对象
     * @param moduleConf
     * @return
     */
    public GenComponent defaultBeforeAction(ModuleConfModel moduleConf){
        GenComponent gc = new DefaultComponent();
        //1：读取相应的模板文件
        GenComponent d1 = new ReadTemplateContent(gc);
        //2：分解模板文件里面需要替换的属性，从moduleConf里面取值替换过去
        GenComponent d2 = new ReplaceProperty(d1);
        return gc;
    }
}
