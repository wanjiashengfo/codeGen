package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.constants.ModuleGenConfEnum;
import com.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.xgen.genconf.implementors.dynamicparse.ParseContext;
import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.GenConfModel;
import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser;
import com.xgen.util.readxml.ReadXmlExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleGenConfXmlImpl implements ModuleGenConfImplementor {
    public ModuleConfModel getBaseModuleConfModel(Map<String, String> param) {
        ModuleConfModel mcm = new ModuleConfModel();
        //设置模块标志
        this.parseModuleId(mcm,this.getContext(param));
        return mcm;
    }

    public Map<String, List<String>> getMapNeedGenTypes( Map<String, String> param) {
        return this.parseNeedGenTypes(this.getContext(param));
    }

    public Map<String, ExtendConfModel> getMapExtends(GenConfModel gm,Map<String, String> param) {
        HashMap<String, ExtendConfModel> map = new HashMap<String, ExtendConfModel>();
        String [] extendIds = parseExtendIds(this.getContext(param));
        String [] isSingle = parseIsSingles(this.getContext(param));
        String [] values = parseValues(this.getContext(param));
        for (int i = 0; i < extendIds.length; i++) {
            ExtendConfModel ecm = new ExtendConfModel();
            ecm.setId(extendIds[i]);
            ecm.setSingle(Boolean.parseBoolean(isSingle[i]));
            ecm.setValue(values[i]);
            if(!ecm.isSingle()){
                ecm.setValues(ecm.getValue().split(ExpressionEnum.comma.getExpr()));
            }
            map.put(ecm.getId(),ecm);
        }
        //等读取完成后 再来动态解析
        ParseContext pctx = new ParseContext();
//        map = (HashMap<String, ExtendConfModel>) pctx.parse(gm ,map);
        return pctx.parse(gm ,map);
    }
    private void parseModuleId(ModuleConfModel mcm, Context c){
        c.init();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf().addDot().addId().build());
        String ss[] = re.interpret(c);
        mcm.setModuleId(ss[0]);

    }
    private Context getContext(Map<String, String> param){
        Context c = null;
        System.out.println("usergenConf路径===="+new GenConfBuilder().addXmlFilePre().addOtherValue(param.get(ModuleGenConfEnum.fileName.toString())).build());
        try {
            c = Context.getInstance(
                    new GenConfBuilder().addXmlFilePre().addOtherValue(param.get(ModuleGenConfEnum.fileName.toString())).build()
            );
//            c = Context.getInstance(
//                    new GenConfBuilder().addXmlFilePre().addOtherValue(param.get(ModuleGenConfEnum.fileName.toString())).build()
//            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    private Map<String,List<String>> parseNeedGenTypes(Context ctx){
        ctx.init();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf()
                .addSeparator().addNeedGenTypes().addSeparator().addNeedGenType()
                .addDollar().addDot().addId().addDollar().build());
        String needGenTypes[] = re.interpret(ctx);
        for (String s : needGenTypes) {
            map.put(s,parseNeedGenOutTypes(ctx,s));
        }
        return map;
    }
    private String[]  parseExtendIds(Context ctx){
        ctx.init();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf()
                .addSeparator().addExtendConfs().addSeparator().addExtendConf()
                .addDollar().addDot().addId().addDollar().build());

        return re.interpret(ctx);
    }
    private String[]  parseIsSingles(Context ctx){
        ctx.init();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf()
                .addSeparator().addExtendConfs().addSeparator().addExtendConf()
                .addDollar().addDot().addIsSingle().addDollar().build());

        return re.interpret(ctx);
    }
    private String[]  parseValues(Context ctx){
        ctx.init();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf()
                .addSeparator().addExtendConfs().addSeparator().addExtendConf()
                .addDollar().build());

        return re.interpret(ctx);
    }

    private List<String> parseNeedGenOutTypes(Context ctx,String needGenId){
        ctx.init();
        List<String> list = new ArrayList<String>();
        ReadXmlExpression re = Parser.parse(new ModuleGenConfBuilder().addModuleGenConf()
                .addSeparator().addNeedGenTypes().addSeparator().addNeedGenType()
                .addDollar()
                .addOpenBracket().addId().addEqual().addOtherValue(needGenId)
                .addCloseBracket().addSeparator()
                .addNeedGenOutType().addDollar()
                .addDot().addId().addDollar().build());
        String ss[] = re.interpret(ctx);
        for(String s:ss){
            list.add(s);
        }
        return list;
    }
}
