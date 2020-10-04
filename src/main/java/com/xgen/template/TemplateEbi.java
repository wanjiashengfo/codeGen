package com.xgen.template;

public interface TemplateEbi {
    /**
     * 按照默认的语法去替换模板中的属性变量
     * @return
     */
    public Object replaceProperties();

    /**
     * 按照默认的语法去运行方法 并把结果替换到模板中
     * 使用访问者来实现
     * @return
     */
    public Object replaceMethods();

    /**
     * 获取模板当前的内容
     * @return
     */
    public Object getNowContent();

}
