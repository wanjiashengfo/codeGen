package com.xgen.geninvocation;

import com.xgen.genconf.vo.ModuleConfModel;

public class GenInvocationFactory {
    private GenInvocationFactory(){

    }

    public static GenInvocation createGenInvocation(String needGenType, ModuleConfModel moduleConf){
        return new DefaultGenInvocation(needGenType,moduleConf);
    }
}
