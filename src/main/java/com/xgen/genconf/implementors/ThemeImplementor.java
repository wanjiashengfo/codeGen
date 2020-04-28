package com.xgen.genconf.implementors;

import com.xgen.genconf.vo.GenTypeModel;

import java.util.Map;

public interface ThemeImplementor {
    /**
     * 根据theme的id
     *在核心框架里面注册theme时配置相应的参数，来获取theme中定义的能生成的功能类型
     * @param themeId
     * @param params
     * @return
     */
    public Map<String,GenTypeModel> getMapGenTypes(String themeId,Map<String,String> params);

    public Map<String,String> getMapGenOutTypes(String themeId,Map<String,String> params);

    public Map<String,String> getMapProviders(String themeId,Map<String,String> params);
}
