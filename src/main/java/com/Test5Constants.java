package com;

import com.xgen.util.readxml.*;

public class Test5Constants {
    public static void main(String[] args) throws Exception {

        ElementExpression genconfa = new ElementExpression("GenConf","");
        ElementExpression needGens = new ElementExpression("NeedGens","");
        ElementsExpression needGen = new ElementsExpression("NeedGen","");
        ElementsExpression params = new ElementsExpression("Params","");
        ElementsTerminalExpression param = new ElementsTerminalExpression("Param","id=fileName");
//        PropertiesTerminalExpression ids = new PropertiesTerminalExpression("id");


//        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        Context context = Context.getInstance("themes/GenConf.xml");


//       //组装一个抽象语法树
        genconfa.addEle(needGens);
        needGens.addEle(needGen);
        needGen.addEle(params);
        params.addEle(param);
//        param.addEle(ids);
        String[] sss = genconfa.interpret(context);

        for (String s : sss) {
            System.out.println("sss=="+s);
        }

    }
}
