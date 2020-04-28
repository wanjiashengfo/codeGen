package com.xgen.genconf;

import com.xgen.genconf.confmanager.ConfManager;
import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.ModuleConfModel;

import java.util.Map;

/**
 * 负责完成配置管理模块的业务功能
 */
public class GenConfEbo implements GenConfEbi {
    private  static GenConfEbo ebo = new GenConfEbo();

    private GenConfEbo() {
    }

    public static GenConfEbi getInstance(){
        return ebo;
    }
    public GenConfModel getGenConf() {
        //获取相应的配置数据
        return ConfManager.getInstance().getGenConf();
    }

    public Map<String, ModuleConfModel> getModuleConf() {
        //获取相应的配置数据
        return ConfManager.getInstance().getMapModuleConf();
    }
}
