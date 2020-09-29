package com.xgen.genconf.implementors.dynamicparse;

import bsh.EvalError;
import bsh.Interpreter;
import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.GenConfModel;

import java.util.Map;

public class BeanShellStrategy implements ParseStrategy{
    public String parseDynamicContent(GenConfModel gm, Map<String, ExtendConfModel> mapEcms, String expr) {
        Interpreter interpreter = new Interpreter();
        String retStr = "";
        try {
            //设置要传入的参数
            interpreter.set("gm",gm);
            interpreter.set("mapEcms",mapEcms);
            //执行
            interpreter.eval("retValue="+expr);
            //获取返回值
            retStr = interpreter.get("retValue").toString();
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }
        return retStr;
    }
}
