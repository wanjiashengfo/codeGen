package com;

import com.xgen.util.readxml.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ElementExpression genconf = new ElementExpression("GenConf","");
        ElementExpression needGens = new ElementExpression("NeedGens","");
        ElementsExpression needGen = new ElementsExpression("NeedGen","id=UserGenConf");

        ElementsTerminalExpression param = new ElementsTerminalExpression("Param","");
//
//       //组装一个抽象语法树
        genconf.addEle(needGens);
        needGens.addEle(needGen);

        needGen.addEle(param);
//        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        Context context = Context.getInstance("themes/GenConf.xml");

//        String[] ss = Parser.parse("GenConf/NeedGens/NeedGen$/Params/Param$[id=fileName2]").interpret(context);
        String[] ss = genconf.interpret(context);
        for (String s : ss) {
            System.out.println(s);
        }

    }
}
