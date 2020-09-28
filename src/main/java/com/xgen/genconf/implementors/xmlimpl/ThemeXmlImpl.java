package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.constants.ModuleGenConfEnum;
import com.xgen.genconf.constants.ThemeEnum;
import com.xgen.genconf.implementors.ThemeImplementor;
import com.xgen.genconf.vo.GenTypeModel;
import com.xgen.util.readxml.Context;

import java.util.HashMap;
import java.util.Map;

public class ThemeXmlImpl implements ThemeImplementor {
    public Map<String, GenTypeModel> getMapGenTypes(String themeId, Map<String, String> params) {
        Map<String, GenTypeModel> map = new HashMap<String, GenTypeModel>();
        String[] genTypeIds = null;
        String[] genTypeValues = null;
        for (int i = 0; i < genTypeIds.length; i++) {
            GenTypeModel gtm = new GenTypeModel();
            gtm.setGenTypeClass(genTypeValues[i]);
            gtm.setId(genTypeIds[i]);

            String[] paramIds = null;
            String[] paramValues = null;
            HashMap<String, String> paramMap = new HashMap<String, String>();
            for (int j = 0; j < paramIds.length; j++) {
                paramMap.put(paramIds[j],paramValues[j]);
            }
            gtm.setMapParams(paramMap);
            map.put(gtm.getId(),gtm);
        }
        return map;
    }

    public Map<String, String> getMapGenOutTypes(String themeId, Map<String, String> params) {
        return null;
    }

    public Map<String, String> getMapProviders(String themeId, Map<String, String> params) {
        return null;
    }
    private Context getContext(Map<String, String> param){
        Context c = null;
        try {
            c = Context.getInstance(
                    param.get(ThemeEnum.Location)+ ExpressionEnum.themeXmlName.getExpr()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

}
