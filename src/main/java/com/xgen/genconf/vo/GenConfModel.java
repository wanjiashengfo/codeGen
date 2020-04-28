package com.xgen.genconf.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * x-gen核心框架对应的数据model
 */
@Data
public class GenConfModel {
    /**
     * 描述注册的多个用户需要生成的模块的model
     */
    private List<NeedGenModel> needGens = new ArrayList<NeedGenModel>();
    /**
     * 描述注册的多个外部主题的model
     */
    private List<ThemeModel> themes = new ArrayList<ThemeModel>();
    /**
     * 描述通用的常量定义的集合
     */
    private Map<String,String> mapconstants = new HashMap<String, String>();

    public ThemeModel getThemeById(String themeId){
        for (ThemeModel theme : this.themes) {
            if(theme.getId().equals(themeId)){
                return theme;
            }
        }
        return new ThemeModel();
    }
}
