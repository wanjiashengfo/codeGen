package com.xgen.genconf.confmanager;

import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.ModuleConfModel;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 负责真正去获取配置数据，并缓存
 */
public class ConfManager {
    private static ConfManager  manager = null;
    private ConfManager() {
        readConf();
    }
    public static ConfManager getInstance(){
        if(manager == null){
            manager = new ConfManager();
        }
        return manager;
    }
    //定义要缓存的数据
    @Getter
    private GenConfModel genConf = new GenConfModel();
    @Getter
    private Map<String, ModuleConfModel> mapModuleConf = new HashMap<String, ModuleConfModel>();

    private void readConf(){
      //这里真正获取配置数据
        //然后把获取到的数据设置到属性上，缓存下来
    }
}
