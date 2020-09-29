package com;

import com.xgen.genconf.implementors.xmlimpl.GenConfBuilder;
import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser;

public class Test8Bugfix {
    public static void main(String[] args) throws Exception {


        Context context = Context.getInstance("themes/GenConf.xml");
        String[] ss;
        //ss = Parser.parse("GenConf/Themes/NeedGen/Theme$").interpret(context);
//        ss = Parser2.parse2("GenConf/NeedGens/NeedGen/Params/Param$.id$").interpret(context);

        ss = Parser.parse(  new GenConfBuilder().addGenConf().addSeparator().addNeedGens()
                .addSeparator().addNeedGen().addDollar().addDot().addThemeId().addDollar().build()
                ).interpret(context);
        for (String s : ss) {
            System.out.println(  s);
        }

    }
}
