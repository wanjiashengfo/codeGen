package com.xgen.genconf;

import com.xgen.genconf.implementors.GenConfImplementor;

public class GenConfFactory {
    private GenConfFactory() {
    }

    public static GenConfEbi createGernConfEbi (GenConfImplementor provider){
        return  GenConfEbo.getInstance(provider);
    }
}
