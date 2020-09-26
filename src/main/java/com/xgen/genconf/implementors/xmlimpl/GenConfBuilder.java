package com.xgen.genconf.implementors.xmlimpl;

public class GenConfBuilder {
    //用来记录分步骤拼接的字符串，也就是最终产品
    private StringBuffer buffer = new StringBuffer();
    //支持连缀
    public GenConfBuilder addGenConf(){
        buffer.append("GenConf");
        return this;
    }
    public GenConfBuilder addNeedGens(){
        buffer.append("NeedGens");
        return this;
    }

    public String build(){
        return buffer.toString();
    }
}
