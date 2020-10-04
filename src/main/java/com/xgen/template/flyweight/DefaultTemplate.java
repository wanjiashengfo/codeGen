package com.xgen.template.flyweight;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.vo.ModuleConfModel;

public class DefaultTemplate implements TemplateFlyweight{
    /**
     * 模板的原始内容
     */
    private String rawContent = "";
    DefaultTemplate(String rawContent){
        this.rawContent = rawContent;
    }
    @Override
    public Object replaceProperties(ModuleConfModel moduleConf, Object content) {
        return this.nowReplaceProperties(moduleConf,content);
    }

    @Override
    public Object replaceMethods(ModuleConfModel moduleConf, Object content) {
        return this.nowReplaceMethods(moduleConf,content);
    }

    @Override
    public Object getRawContent() {
        return this.rawContent;
    }

    private Object nowReplaceMethods(ModuleConfModel moduleConf,Object content){
        //首先要读取相应的模板原始内容
        String templateContent =(String) content;
        int begin = templateContent.indexOf(ExpressionEnum.methodBeginStr.getExpr());
        if(begin>=0) {
            int end = begin + ExpressionEnum.methodBeginStr.getExpr().length()
                    + templateContent.substring(begin + ExpressionEnum.methodEndStr.getExpr().length()).indexOf(ExpressionEnum.methodEndStr.getExpr());
            //获得模板中需要的属性
            String className =  templateContent.substring(begin+ExpressionEnum.methodBeginStr.getExpr().length(),end);
            //运行method获取到结果值
            String methodValue = "";
            //把这个值替换到模板当中的相应位置去
            templateContent = templateContent.replace(ExpressionEnum.propBeginStr.getExpr()
                    +className+ExpressionEnum.propEndStr.getExpr(),methodValue);
            //一直替换到模板内容里面没有可替换的内容就结束了
            //递归
            templateContent = ""+nowReplaceProperties(moduleConf,templateContent);
        }
        return templateContent;
    }
    private Object nowReplaceProperties(ModuleConfModel moduleConf,Object content){
        //首先要读取相应的模板原始内容
        String templateContent =(String) content;
        //分解模板的原始内容 得到需要处理的properties
        int begin = templateContent.indexOf(ExpressionEnum.propBeginStr.getExpr());
        if(begin>=0){
            int end = begin + ExpressionEnum.propEndStr.getExpr().length()
                    +templateContent.substring(begin + ExpressionEnum.propEndStr.getExpr().length()).indexOf(ExpressionEnum.propEndStr.getExpr());
            //获得模板中需要的属性

            String prop = templateContent.substring(begin+ExpressionEnum.propBeginStr.getExpr().length(),end);
            //从ModuleConfModel得到相应的property值
            String propValue = moduleConf.getMapExtends().get(prop).getValue();
            //把这个值替换到模板当中的相应位置去
            templateContent = templateContent.replace(ExpressionEnum.propBeginStr.getExpr()
            +prop+ExpressionEnum.propEndStr.getExpr(),propValue);
            //一直替换到模板内容里面没有可替换的内容就结束了
            //递归
            templateContent = ""+nowReplaceProperties(moduleConf,templateContent);
        }
        return templateContent;
    }
}
