package com.xgen.template.flyweight;

import com.xgen.genconf.GenConfFactory;
import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.mediator.CoreMediator;
import com.xgen.util.file.FileHelper;

import java.util.HashMap;
import java.util.Map;

public class TemplateFlyweightFactory {
    //通常实现为单例
    public static TemplateFlyweightFactory factory = new TemplateFlyweightFactory();
    private TemplateFlyweightFactory(){

    }
    public static TemplateFlyweightFactory getInstance(){
        return factory;
    }
    //缓存享元对象
    Map<String,DefaultTemplate> mapTemplate =new HashMap<String,DefaultTemplate>();

    public DefaultTemplate getTemplateFlyweight(String templatePath){
        Object obj = mapTemplate.get(templatePath);
        if(obj==null){
            DefaultTemplate dt = new DefaultTemplate(FileHelper.readFile(templatePath));
            mapTemplate.put(templatePath,dt);
            return dt;
        }else {
            return (DefaultTemplate)obj;
        }
    }

    public DefaultTemplate getTemplateFlyweight(ModuleConfModel moduleConf,String genTypeId){
        //帮助拼接模板文件的位置
        String mbPathFile = CoreMediator.getInstance().getThemeMbPathFile(moduleConf,genTypeId);
        String themePath = CoreMediator.getInstance().getThemePath(moduleConf);
        String templatePath = themePath + ExpressionEnum.separator.getExpr() + ExpressionEnum.template.getExpr()
                + ExpressionEnum.separator.getExpr() + mbPathFile;
        return getTemplateFlyweight(templatePath);
    }
}
