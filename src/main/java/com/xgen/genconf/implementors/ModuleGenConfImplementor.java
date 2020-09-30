package com.xgen.genconf.implementors;

import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.ModuleConfModel;

import java.util.List;
import java.util.Map;

public interface ModuleGenConfImplementor {
    /**
     * 根据核心框架里面注册的需要生成模块的配置参数获取相应的基本的需要生成的模块的配置数据model，只有基本的部分
     * @param params
     * @return
     */
    public ModuleConfModel getBaseModuleConfModel(Map<String,String> params);

    /**
     * 根据配置参数来获取需要生成的功能类型
     * @param params
     * @return
     */

    public Map<String,List<String>> getMapNeedGenTypes(Map<String,String> params);

    public Map<String,ExtendConfModel> getMapExtends(GenConfModel gm,Map<String,String> params);
}
