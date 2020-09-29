package com;

import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.ElementExpression;
import com.xgen.util.readxml.ElementsExpression;
import com.xgen.util.readxml.ElementsTerminalExpression;

public class Test3Constants {
    public static void main(String[] args) throws Exception {

        ElementExpression genconfa = new ElementExpression("GenConf","");
        ElementExpression needGens = new ElementExpression("NeedGens","");
        ElementsExpression needGen = new ElementsExpression("NeedGen","");
        ElementsExpression params = new ElementsExpression("Params","");
        ElementsTerminalExpression param = new ElementsTerminalExpression("Param","");


//        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        Context context = Context.getInstance("themes/GenConf.xml");


//       //组装一个抽象语法树
        genconfa.addEle(needGens);
        needGens.addEle(needGen);
        needGen.addEle(params);
        params.addEle(param);
        String[] sss = genconfa.interpret(context);

        for (String s : sss) {
            System.out.println("sss=="+s);
        }

    }
}
