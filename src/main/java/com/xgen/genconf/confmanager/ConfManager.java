package com.xgen.genconf.confmanager;

import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.genconf.vo.NeedGenModel;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 负责真正去获取配置数据，并缓存配置数据
 */
public class ConfManager {
    //实现成单例
    private static ConfManager  manager = null;
    private ConfManager(GenConfImplementor provider) {
        readConf(provider);
    }
    public static ConfManager getInstance(GenConfImplementor provider){
        if(manager == null){
            manager = new ConfManager(provider);
        }
        return manager;
    }
    //定义要缓存的数据
    @Getter
    private GenConfModel genConf = new GenConfModel();
    @Getter
    private Map<String, ModuleConfModel> mapModuleConf = new HashMap<String, ModuleConfModel>();

    private void readConf(GenConfImplementor provider){
      //这里真正获取配置数据
        readGenConf(provider);
        //然后把获取到的数据设置到属性上，缓存下来
        for (NeedGenModel needGenModel : genConf.getNeedGens()) {
            readOneModelGenConf(needGenModel);
        }
    }

    private void readOneModelGenConf(NeedGenModel needGenModel){
        ModuleConfModel moduleConfModel = new ModuleConfModel();
        String providerClassName = this.genConf.getThemeById(needGenModel.getTheme()).getMapProviders().get(needGenModel.getProvider());
        ModuleGenConfImplementor  userGenConfImpl = null;
        try {
            userGenConfImpl = (ModuleGenConfImplementor) Class.forName(providerClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        moduleConfModel = userGenConfImpl.getBaseModuleConfModel(needGenModel.getMapParams());
        moduleConfModel.setUseTheme(needGenModel.getTheme());
        moduleConfModel.setMapNeedGenTypes(userGenConfImpl.getMapNeedGenTypes(needGenModel.getMapParams()));
        moduleConfModel.setMapExtends(userGenConfImpl.getMapExtends(genConf,needGenModel.getMapParams()));
        this.mapModuleConf.put(moduleConfModel.getModuleId(),moduleConfModel);
    }
    private void readGenConf(GenConfImplementor provider){
        genConf.setNeedGens(provider.getNeedGens());
        genConf.setThemes(provider.getThemes());
        genConf.setMapConstants(provider.getMapConstants());
    }
}
