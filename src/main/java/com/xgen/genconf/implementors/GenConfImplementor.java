package com.xgen.genconf.implementors;

import com.xgen.genconf.vo.NeedGenModel;
import com.xgen.genconf.vo.ThemeModel;

import java.util.List;
import java.util.Map;

/**
 * 获取核心框架配置数据的接口
 */
public interface GenConfImplementor {
    /**
     * 获取核心框架配置中注册的需要生成的模块
     * @return
     */
    public List<NeedGenModel> getNeedGens();

    /**
     * 获取核心框架配置中注册外部主题的配置主题
     * @return
     */
    public List<ThemeModel> getThemes();
    /**
     * 获取核心框架配置中注册外部主题的公共常亮
     * @return
     */
    public Map<String,String> getMapConstants();
}
