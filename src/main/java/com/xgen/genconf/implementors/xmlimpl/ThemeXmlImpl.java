package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.constants.ModuleGenConfEnum;
import com.xgen.genconf.constants.ThemeEnum;
import com.xgen.genconf.implementors.ThemeImplementor;
import com.xgen.genconf.vo.GenTypeModel;
import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser;
import com.xgen.util.readxml.ReadXmlExpression;

import java.util.HashMap;
import java.util.Map;

public class ThemeXmlImpl implements ThemeImplementor {
    public Map<String, GenTypeModel> getMapGenTypes(String themeId, Map<String, String> param) {
        Map<String, GenTypeModel> map = new HashMap<String, GenTypeModel>();
        String[] genTypeIds = parseGenTypeIds(this.getContext(param));
        String[] genTypeValues = parseGenTypeValues(this.getContext(param));;
        for (int i = 0; i < genTypeIds.length; i++) {
            GenTypeModel gtm = new GenTypeModel();
            gtm.setGenTypeClass(genTypeValues[i]);
            gtm.setId(genTypeIds[i]);

            String[] paramIds = parseGenTypeParamIds(this.getContext(param),gtm.getId());
            String[] paramValues = parseGenTypeParamValues(this.getContext(param),gtm.getId());
            HashMap<String, String> paramMap = new HashMap<String, String>();
            for (int j = 0; j < paramIds.length; j++) {
                paramMap.put(paramIds[j],paramValues[j]);
            }
            gtm.setMapParams(paramMap);
            map.put(gtm.getId(),gtm);
        }
        return map;
    }

    public Map<String, String> getMapGenOutTypes(String themeId, Map<String, String> param) {
        HashMap<String, String> map = new HashMap<String, String>();
        String[] genOutTypeIds= parseOutTypeIds(this.getContext(param));
        String[] genOutTypeValues= parseOutTypeValues(this.getContext(param));
        for (int i = 0; i < genOutTypeIds.length; i++) {
            map.put(genOutTypeIds[i],genOutTypeValues[i]);
        }
        return map;
    }

    public Map<String, String> getMapProviders(String themeId, Map<String, String> param) {
        HashMap<String, String> map = new HashMap<String, String>();
        String[] genProviderIds= parseProviderIds(this.getContext(param));
        String[] genProviderValues= parseProviderValues(this.getContext(param));
        for (int i = 0; i < genProviderIds.length; i++) {
            map.put(genProviderIds[i],genProviderValues[i]);
        }
        return map;
    }
    private Context getContext(Map<String, String> param){
        Context c = null;
        try {
            c = Context.getInstance(
                    param.get(ExpressionEnum.location.getExpr())+ExpressionEnum.separator.getExpr()+ ExpressionEnum.themeXmlName.getExpr()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    private String[] parseGenTypeIds(Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes()
                .addSeparator().addGenType().addDollar()
                .addDot().addId().addDollar().build());
        return re.interpret(c);
    }
    private String[] parseGenTypeValues(Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes()
                .addSeparator().addGenType().addDollar()
                .addDot().addType().addDollar().build());
        return re.interpret(c);
    }
    private String[] parseGenTypeParamIds(Context c,String genTypeId){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes()
                .addSeparator().addGenType().addDollar()
                .addOpenBracket().addId().addEqual().addOtherValue(genTypeId).addCloseBracket()
                .addSeparator().addParams().addSeparator()
                .addParam().addDollar()
                .addDot().addId().addDollar().build());
        return re.interpret(c);
    }
    private String[] parseGenTypeParamValues(Context c,String genTypeId){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenTypes()
                .addSeparator().addGenType().addDollar()
                .addOpenBracket().addId().addEqual().addOtherValue(genTypeId).addCloseBracket()
                .addSeparator().addParams().addSeparator()
                .addParam().addDollar()
                .build());
        return re.interpret(c);
    }

    private String[] parseOutTypeIds(Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenOutTypes()
                .addSeparator().addGenOutType().addDollar()
                .addDot().addId().addDollar().build());
        return re.interpret(c);
    }
    private String[] parseOutTypeValues(Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addGenOutTypes()
                .addSeparator().addGenOutType().addDollar()
                .addDot().addType().addDollar().build());
        return re.interpret(c);
    }
    private String[] parseProviderIds(Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addProviders()
                .addSeparator().addProvider().addDollar()
                .addDot().addId().addDollar().build());
        return re.interpret(c);
    }
    private String[] parseProviderValues(Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ThemeBuilder().addTheme().addSeparator().addProviders()
                .addSeparator().addProvider().addDollar()
                .addDot().addType().addDollar().build());
        return re.interpret(c);
    }
}
