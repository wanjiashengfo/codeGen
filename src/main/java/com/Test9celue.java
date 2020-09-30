package com;

import com.xgen.genconf.GenConfEbi;
import com.xgen.genconf.GenConfFactory;
import com.xgen.genconf.implementors.xmlimpl.GenConfBuilder;
import com.xgen.genconf.implementors.xmlimpl.GenConfXmlImpl;
import com.xgen.util.readxml.Context;
import com.xgen.util.readxml.Parser;

public class Test9celue {
    public static void main(String[] args) throws Exception {


        GenConfEbi ebi = GenConfFactory.createGernConfEbi(new GenConfXmlImpl());
//        System.out.println("gm======"+ebi.getGenConf());
        System.out.println("gm======"+ebi.getMapModuleConf());

    }
}
