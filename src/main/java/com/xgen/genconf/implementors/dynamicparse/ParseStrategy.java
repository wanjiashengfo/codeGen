package com.xgen.genconf.implementors.dynamicparse;

import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.GenConfModel;

import java.util.Map;
//进行模块配置中需要动态解析的字符串的策略接口
public interface ParseStrategy {
    //解析动态内容 获得最终完整的字符串

    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms,String expr);
}
