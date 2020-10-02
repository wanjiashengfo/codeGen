package com.xgen.geninvocation.decorator;

import com.xgen.genconf.vo.ModuleConfModel;

public abstract class GenDecorator extends GenComponent{
    /**
     * 持有组件对象
     */
    protected GenComponent component;

    public GenDecorator(GenComponent component){
        this.component = component;
    }
    @Override
    public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
        //缺省的实现 转发请求给具体的组件对象
        return this.component.operation(moduleConf,genTypeId,obj);
    }
}
