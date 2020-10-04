package com.xgen.template.flyweight;

import com.xgen.genconf.vo.ModuleConfModel;

public interface TemplateFlyweight {
    /**
     * 根据配置和默认语法来替换模板中的属性值
     * @param moduleConf
     * @param content
     * @return
     */
    public Object replaceProperties(ModuleConfModel moduleConf,Object content);
    /**
     * 根据配置和默认语法来运行方法 替换模板中的相应的值
     * @param moduleConf
     * @param content
     * @return
     */
    public Object replaceMethods(ModuleConfModel moduleConf,Object content);

    /**
     * 获取原始的模板文件内容
     * @return
     */
    public Object getRawContent();
}
