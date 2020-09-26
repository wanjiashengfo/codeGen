package com.xgen.genconf;

import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.ModuleConfModel;

import java.util.Map;

public interface GenConfEbi {
    /**
     * 获取x-gen核心框架运行所需要的配置数据model
     *
     * @return
     */
    public GenConfModel getGenConf();

    /**
     * 获取需要生成的所有模块的配置
     * @return key模块名称 value相应模块的配置数据
     */
    public Map<String,ModuleConfModel> getMapModuleConf();
}
