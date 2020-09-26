package com;

import com.xgen.util.readxml.*;

public class Test6jiexiqi {
    public static void main(String[] args) throws Exception {


        Context context = Context.getInstance("xgenconfxml/GenConf.xml");
        String[] ss;
        ss = Parser2.parse2("GenConf/NeedGens/NeedGen/Params/Param$[id=fileName2]").interpret(context);
//        ss = Parser2.parse2("GenConf/NeedGens/NeedGen/Params/Param$.id$").interpret(context);


        for (String s : ss) {
            System.out.println(  s);
        }

    }
}
