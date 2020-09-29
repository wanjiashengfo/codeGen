package com;

import com.xgen.util.readxml.*;

public class MyTest {
    public static void main(String[] args) throws Exception {
        ElementExpression Theme = new ElementExpression("Theme","");
        ElementExpression GenTypes = new ElementExpression("GenTypes","");
        ElementExpression GenType = new ElementExpression("GenType","");
        ElementExpression params = new ElementExpression("Params","");
        ElementExpression param = new ElementExpression("Param","");
        PropertyTerminalExpression id = new PropertyTerminalExpression("id");
//
//       //组装一个抽象语法树
        Theme.addEle(GenTypes);
        GenTypes.addEle(GenType);

        GenType.addEle(params);
        params.addEle(param);
        param.addEle(id);
//        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        Context context = Context.getInstance("themes.simple/ThemeConf.xml");

//        String[] ss = Parser.parse("GenConf/NeedGens/NeedGen$/Params/Param$[id=fileName2]").interpret(context);
        String[] ss = Theme.interpret(context);
        System.out.println(ss[0]);
//        for (String s : ss) {
//            System.out.println(s);
//        }

    }
}
