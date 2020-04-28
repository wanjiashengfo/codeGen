package com.xgen.genconf;

public class GenConfFactory {
    private GenConfFactory() {
    }

    public static GenConfEbi createGernConfEbi (){
        return  GenConfEbo.getInstance();
    }
}
