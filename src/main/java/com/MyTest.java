package com;

import com.xgen.util.readxml.*;

public class MyTest {
    public static void main(String[] args) throws Exception {
        ElementExpression genconf = new ElementExpression("GenConf","");
        ElementExpression needGens = new ElementExpression("NeedGens","");
        ElementExpression needGen = new ElementExpression("NeedGen","");
        ElementExpression params = new ElementExpression("Params","");
        ElementExpression param = new ElementExpression("Param","");
        PropertyTerminalExpression id = new PropertyTerminalExpression("id");
//
//       //组装一个抽象语法树
        genconf.addEle(needGens);
        needGens.addEle(needGen);

        needGen.addEle(params);
        params.addEle(param);
        param.addEle(id);
//        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        Context context = Context.getInstance("xgenconfxml/GenConf.xml");

//        String[] ss = Parser.parse("GenConf/NeedGens/NeedGen$/Params/Param$[id=fileName2]").interpret(context);
        String[] ss = genconf.interpret(context);
        System.out.println(ss[0]);
//        for (String s : ss) {
//            System.out.println(s);
//        }

    }
}
