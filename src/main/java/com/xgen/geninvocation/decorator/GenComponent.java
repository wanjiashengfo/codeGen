package com.xgen.geninvocation.decorator;

import com.xgen.genconf.vo.ModuleConfModel;

public abstract class GenComponent {
    /**
     * 执行一步generate的功能
     * @param moduleConf
     * @param genTypeId
     * @param obj
     * @return
     */
    public abstract Object operation(ModuleConfModel moduleConf,String genTypeId,Object obj);
}
