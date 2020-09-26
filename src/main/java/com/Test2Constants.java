package com;

import com.xgen.util.readxml.*;

public class Test2Constants {
    public static void main(String[] args) throws Exception {
        ElementExpression genconf = new ElementExpression("GenConf","");
        ElementExpression constants = new ElementExpression("Constants","");
        ElementsTerminalExpression constant = new ElementsTerminalExpression("Constant","");

        ElementExpression genconfa = new ElementExpression("GenConf","");
        ElementExpression needGens = new ElementExpression("NeedGens","");
        ElementsExpression needGen = new ElementsExpression("NeedGen","");
        ElementsExpression params = new ElementsExpression("Params","");
        ElementsTerminalExpression param = new ElementsTerminalExpression("Param","");
//
//       //组装一个抽象语法树
        genconf.addEle(constants);
        constants.addEle(constant);

//        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

//        String[] ss = Parser.parse("GenConf/NeedGens/NeedGen$/Params/Param$[id=fileName2]").interpret(context);
        String[] ss = genconf.interpret(context);

        for (String s : ss) {
            System.out.println("ss=="+s);
        }
        System.out.println("=========");
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
