package com.xgen.geninvocation.decorator;

import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.mediator.CoreMediator;

public class ReplaceMethods extends GenDecorator{
    public ReplaceMethods(GenComponent component) {
        super(component);
    }
    @Override
    public Object operation(ModuleConfModel moduleConf, String genTypeId, Object obj) {
        //先要获得上一步处理完成的内容
        obj = this.component.operation(moduleConf,genTypeId,obj);

        return CoreMediator.getInstance().templateReplaceMethods(obj);
    }
}
