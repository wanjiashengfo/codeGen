package com.xgen.mediator;

import com.xgen.genconf.GenConfFactory;
import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.implementors.xmlimpl.GenConfXmlImpl;
import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.geninvocation.DefaultGenInvocation;
import com.xgen.geninvocation.GenInvocation;
import com.xgen.geninvocation.GenInvocationFactory;
import com.xgen.genproxy.GenProxyFactory;
import com.xgen.template.TemplateEbi;
import com.xgen.template.TemplateFactory;

import java.util.Collection;
import java.util.List;
import java.util.Observer;

/**
 * 核心框架的中介者对象
 */
public class CoreMediator {
    //实现成为单例
    private static CoreMediator mediator = new CoreMediator();
    private CoreMediator(){

    }

    public static CoreMediator getInstance(){
        return mediator;
    }
    public GenConfImplementor getDefaultGenConfProvider(){
        return new GenConfXmlImpl();
    }
    public Collection<ModuleConfModel> genNeedGenModuleConf(GenConfImplementor provider){
        return  GenConfFactory.createGernConfEbi(provider).getMapModuleConf().values();
    }

    public void needProxyGen(String needGenType, ModuleConfModel moduleConf){

        GenProxyFactory.createGenProxy( needGenType,  moduleConf).executeGen();
    }

    public GenInvocation getDefaultGenInvocation(String needGenType, ModuleConfModel moduleConf){
        GenInvocation invocation = GenInvocationFactory.createGenInvocation(needGenType, moduleConf);
        return invocation;
    }
    public String getNeedGenTypeClass(String needGenType, ModuleConfModel moduleConf){
        return GenConfFactory.createGernConfEbi().getThemeGenType(moduleConf,needGenType).getGenTypeClass();
    }

    public Object getTemplateContent(ModuleConfModel moduleConf,String genTypeId){
        //直接传递模板管理的对象
        return TemplateFactory.createTemplateEbi(moduleConf,genTypeId);
    }

    public Object templateReplaceProperties(Object obj){
        return ((TemplateEbi)obj).replaceProperties();
    }

    public Object templateReplaceMethods(Object obj){
        return ((TemplateEbi)obj).replaceMethods();
    }

    public void registerObservers(DefaultGenInvocation ctx){
        //1.相应的needGenOutType的id
        List<String> needGenOutTypeIds = ctx.getModuleConf().getMapNeedGenTypes().get(ctx.getNeedGenType());
        //2.根据needGenOutType的id获取相应的outType的类的定义
        for (String needGenOutTypeId : needGenOutTypeIds) {
            String genOutTypeClass = GenConfFactory.createGernConfEbi().getThemeGenOutTypeClass(ctx.getModuleConf(),needGenOutTypeId);
            //3.用反射创建这些类的实例，这些类就是observer
            try {
                Observer o = (Observer) Class.forName(genOutTypeClass).newInstance();
                ctx.addObserver(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String getThemeMbPathFile(ModuleConfModel moduleConf,String genTypeId){
        return GenConfFactory.createGernConfEbi().getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenTypes().get(genTypeId)
                .getMapParams().get("mbPathFile");
    }

    public String getThemePath(ModuleConfModel moduleConf){
        return  GenConfFactory.createGernConfEbi().getGenConf()
                .getThemeById(moduleConf.getUseTheme()).getLocation();
    }

}
