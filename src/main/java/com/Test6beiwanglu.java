package com;

import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser;

public class Test6beiwanglu {
    public static void main(String[] args) throws Exception {


        Context context = Context.getInstance("themes/GenConf.xml");
        String[] ss;
        ss = Parser.parse("GenConf/NeedGens/NeedGen/Params/Param$").interpret(context);
//        ss = Parser2.parse2("GenConf/NeedGens/NeedGen/Params/Param$.id$").interpret(context);


        for (String s : ss) {
            System.out.println(  s);
        }

    }
}
