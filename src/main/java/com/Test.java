package com;

import com.xgen.util.readxml.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ElementExpression genconf = new ElementExpression("GenConf","");
        ElementExpression needGens = new ElementExpression("NeedGens","");
        ElementsExpression needGen = new ElementsExpression("NeedGen","");
        ElementsExpression params = new ElementsExpression("Params","");
        ElementsTerminalExpression param = new ElementsTerminalExpression("Param","id=fileName");

       //组装一个抽象语法树
        genconf.addEle(needGens);
        needGens.addEle(needGen);
        needGen.addEle(params);
        params.addEle(param);
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

        String[] ss = genconf.interpret(context);

        for (String s : ss) {
            System.out.println(s);
        }

    }
}
