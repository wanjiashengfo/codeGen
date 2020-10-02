package com.xgen.genconf;

import com.xgen.genconf.confmanager.ConfManager;
import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.GenTypeModel;
import com.xgen.genconf.vo.ModuleConfModel;

import java.util.Map;

/**
 * 负责完成配置管理模块的业务功能
 */
public class GenConfEbo implements GenConfEbi {
    private  static GenConfEbo ebo = null;

    private GenConfEbo(GenConfImplementor provider) {
        this.provider = provider;
    }

    public static GenConfEbi getInstance(GenConfImplementor provider){
        if(ebo==null){
            if(provider==null){
                throw new IllegalArgumentException("第一次创建配置对象，provider不能为空");
            }
            ebo = new GenConfEbo(provider);
        }
        return ebo;
    }

    private GenConfImplementor provider = null;



    public GenConfModel getGenConf() {
        //获取相应的配置数据
        return ConfManager.getInstance(provider).getGenConf();
    }

    public Map<String, ModuleConfModel> getMapModuleConf() {
        //获取相应的配置数据
        return ConfManager.getInstance(provider).getMapModuleConf();
    }

    @Override
    public GenTypeModel getThemeGenType(ModuleConfModel moduleConf, String needGenTypeId) {
        return getGenConf().getThemeById(moduleConf.getUseTheme()).getMapGenTypes().get(needGenTypeId);

    }
}
