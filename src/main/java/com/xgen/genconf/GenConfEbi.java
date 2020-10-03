package com.xgen.genconf;

import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.GenTypeModel;
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
    //提供点友好方法

    /**
     * 根据需要生成的模块配置和theme中生成类型的编号 来获取相应的theme中的生成类型的model
     * @param moduleConf
     * @param needGenTypeId
     * @return
     */
    public GenTypeModel getThemeGenType(ModuleConfModel moduleConf,String needGenTypeId);
    /**
     * 根据需要生成的模块配置和theme中输出类型的编号 来获取相应的输出类型的类
     * @param moduleConf
     * @param needGenTypeId
     * @return
     */
    public String getThemeGenOutTypeClass(ModuleConfModel moduleConf,String needGenOutTypeId);
}
