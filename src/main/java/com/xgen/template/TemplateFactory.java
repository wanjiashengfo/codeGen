package com.xgen.template;

import com.xgen.genconf.vo.ModuleConfModel;

public class TemplateFactory {
    private TemplateFactory(){}

    public static TemplateEbi createTemplateEbi(ModuleConfModel moduleConf){
        return new DefaultTemplateEbo(moduleConf);
    }
}
