package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.constants.GenConfEnum;
import com.xgen.genconf.constants.ThemeEnum;
import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.implementors.ThemeImplementor;
import com.xgen.genconf.vo.NeedGenModel;
import com.xgen.genconf.vo.ThemeModel;
import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser;
import com.xgen.util.readxml.ReadXmlExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenConfXmlImpl implements GenConfImplementor {
    //1.通过builder来获取用于取值的字符串
    //2.使用这些字符串，通过parser去获取到配置的数据，
    //3.然后把这些数据组装成GenConfImplementor所需要的的样子
    public List<NeedGenModel> getNeedGens() {
        return readNeedGens();
    }

    public List<ThemeModel> getThemes() {
        return readThemes();
    }

    public Map<String, String> getMapConstants() {
        return readMapConstants();
    }

    private Context getContext(){
        Context c = null;
        try {
            c = Context.getInstance(
                    new GenConfBuilder().addXmlFilePre().addGenConf().addDot().addXml().build()
                  );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    private List<NeedGenModel> readNeedGens(){
        List<NeedGenModel> retList = new ArrayList<NeedGenModel>();
        Context c = getContext();
        //分别获取相应的数据
        String[] needGenIds = parseNeedGenIds(c);
        String[] needGenProviders = parseNeedGenProviders(c);
        String[] needGenThemes = parseNeedGenThemes(c);
        //开始组装
        for(int i = 0; i < needGenIds.length;i++){
            NeedGenModel ngm = new NeedGenModel();
            ngm.setId(needGenIds[i]);
            ngm.setProvider(needGenProviders[i]);
            ngm.setTheme(needGenThemes[i]);

            String[] paramIds = parseParamIds(c,ngm.getId());
            String[] paramValues = parseParamValues(c,ngm.getId());
            //组装param
            Map<String,String> mapParams = new HashMap<String,String>();
            for(int j = 0;j<paramIds.length;j++){
                mapParams.put(paramIds[j],paramValues[j]);
            }
            ngm.setMapParams(mapParams);
            retList.add(ngm);
        }
        return retList;
    }

    private List<ThemeModel> readThemes(){
        List<ThemeModel> retList = new ArrayList<ThemeModel>();
        Context c = getContext();
        String[] ids = parseThemeIds(c);
        String[] locations = parseThemeLocations(c);
        for(int i = 0;i < ids.length;i++){
            ThemeModel tm = new ThemeModel();
            ThemeImplementor themeImpl = new ThemeXmlImpl();
            HashMap<String, String> params = new HashMap<String, String>();
            params.put(ThemeEnum.Location.toString(),locations[i]);
            tm.setId(ids[i]);
            tm.setLocation(locations[i]);
            tm.setMapGenOutTypes(themeImpl.getMapGenOutTypes(ids[i],params));
            tm.setMapGenTypes(themeImpl.getMapGenTypes(ids[i],params));
            tm.setMapProviders(themeImpl.getMapProviders(ids[i],params));
            retList.add(tm);
        }
        return retList;
    }

    private Map<String,String> readMapConstants(){
        HashMap<String, String> map = new HashMap<String, String>();
        Context c = this.getContext();
        String[] ids = parseConstantIds(c);
        String[] values = parseConstantValues(c);
        for(int i =0;i<ids.length;i++){
            map.put(ids[i],values[i]);
        }
        return map;
    }



    private String[] parseNeedGenIds(Context c){
        c.init();
        //genConf/needgens/needgen$.id$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addNeedGens()
                .addSeparator().addNeedGen().addDollar().addDot().addId().addDollar().build()
        );
        return re.interpret(c);
    }
    private String[] parseNeedGenProviders(Context c){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addNeedGens()
                .addSeparator().addNeedGen().addDollar().addDot().addProvider().addDollar().build()
        );
        return re.interpret(c);
    }
    private String[] parseNeedGenThemes(Context c){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addNeedGens()
                .addSeparator().addNeedGen().addDollar().addDot().addThemeId().addDollar().build()
        );
        return re.interpret(c);
    }
    private String[] parseParamIds(Context c,String needGenId){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addNeedGens()
                .addSeparator().addNeedGen().addDollar()
                        .addOpenBracket().addId().addEqual().addOtherValue(needGenId)
                        .addCloseBracket().addSeparator().addParams().addDollar()
                        .addSeparator().addParam().addDollar()
                        .addDot().addId().addDollar().build()
        );
        return re.interpret(c);
    }
    private String[] parseParamValues(Context c,String needGenId){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addNeedGens()
                .addSeparator().addNeedGen().addDollar()
                        .addOpenBracket().addId().addEqual().addOtherValue(needGenId)
                        .addCloseBracket().addSeparator().addParams().addDollar()
                        .addSeparator().addParam().addDollar()
                        .build()
        );
        return re.interpret(c);
    }
    private String[] parseThemeIds(Context c){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addThemes()
                .addSeparator().addTheme().addDollar()
                        .addDot().addId().addDollar()
                        .build()
        );
        return re.interpret(c);
    }
    private String[] parseConstantIds(Context c){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addConstants()
                .addSeparator().addConstant().addDollar()
                        .addDot().addId().addDollar()
                        .build()
        );
        return re.interpret(c);
    }
    private String[] parseConstantValues(Context c){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addConstants()
                .addSeparator().addConstant().addDollar()
                        .build()
        );
        return re.interpret(c);
    }
    private String[] parseThemeLocations(Context c){
        c.init();
        //genConf/needgens/needgen$.provider$
        ReadXmlExpression re = Parser.parse(
                new GenConfBuilder().addGenConf().addSeparator().addThemes()
                .addSeparator().addTheme().addDollar()
                        .build()
        );
        return re.interpret(c);
    }
}
