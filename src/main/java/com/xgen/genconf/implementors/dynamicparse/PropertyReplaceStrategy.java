package com.xgen.genconf.implementors.dynamicparse;

import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.GenConfModel;

import java.util.Map;

public class PropertyReplaceStrategy implements ParseStrategy{
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr) {
        String retStr = "";
        ExtendConfModel ecm = mapEcms.get(expr);
        if(ecm != null){
            retStr = ecm.getValue();
        }
        return retStr;
    }
}
