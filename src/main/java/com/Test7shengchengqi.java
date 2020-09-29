package com;

import com.xgen.genconf.GenConfEbi;
import com.xgen.genconf.GenConfFactory;
import com.xgen.genconf.implementors.xmlimpl.GenConfXmlImpl;
import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser2;

public class Test7shengchengqi {
    public static void main(String[] args) throws Exception {
        GenConfEbi ebi = GenConfFactory.createGernConfEbi(new GenConfXmlImpl());
//        System.out.println("gm======"+ebi.getGenConf());
        System.out.println("gm======"+ebi.getMapModuleConf());
    }
}
