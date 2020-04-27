package com.xgen.genconf.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class ModuleConfModel {
    /**
     * 用户需要生成的模块的标志
     */
    private String moduleId = "";
    /**
     * 用户需要生成的外部主题的标志
     */
    private String useTheme = "";
    /**
     * 用户需要生成的具体功能
     */
    private Map<String,List<String>> maNeedGenTypes = new HashMap<String, List<String>>();
    /**
     * 模块生成需要的扩展数据
     */
    private Map<String,ExtendConfModel> mapExtends = new HashMap<String,ExtendConfModel>();
}
