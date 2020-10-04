package com.xgen.template.visitors;

import com.xgen.genconf.vo.ModuleConfModel;
import lombok.Getter;

public class TemplateElement {
    @Getter
    private ModuleConfModel moduleConf;
    public TemplateElement(ModuleConfModel moduleConf){
        this.moduleConf = moduleConf;
    }

    /**
     * 接受访问的方法 也就是预留的调用通道
     * @param v
     * @return
     */
    public Object accept(Visitor v){
        return v.visitTemplateElement(this);
    }
}
