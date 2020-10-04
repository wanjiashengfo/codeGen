package com.xgen.template;

import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.template.flyweight.TemplateFlyweight;
import com.xgen.template.flyweight.TemplateFlyweightFactory;

public class DefaultTemplateEbo implements TemplateEbi{
    /**
     * 模块配置的数据model
     */
    private ModuleConfModel moduleConf;
    /**
     * 需要生成的类型标识
     */
    private String genTypeId;
    /**
     * 当前被模板处理过后的内容
     */
    private Object nowContent;

    private TemplateFlyweight flyweight = null;

    public DefaultTemplateEbo(ModuleConfModel moduleConf,String genTypeId){
        this.moduleConf = moduleConf;
        this.genTypeId = genTypeId;
        //初始化
        flyweight = TemplateFlyweightFactory.getInstance().getTemplateFlyweight(moduleConf,this.genTypeId);
        nowContent = flyweight.getRawContent();
    }

    @Override
    public Object replaceProperties() {
        this.nowContent = flyweight.replaceProperties(moduleConf,this.nowContent);
        return this;
    }

    @Override
    public Object replaceMethods() {
        this.nowContent = flyweight.replaceMethods(moduleConf,this.nowContent);
        return this;
    }

    @Override
    public Object getNowContent() {
        return this.nowContent;
    }
}
