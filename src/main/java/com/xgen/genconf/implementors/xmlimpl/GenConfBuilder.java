package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.constants.GenConfEnum;

public class GenConfBuilder extends CommonBuilder<GenConfBuilder>{
    //用来记录分步骤拼接的字符串，也就是最终产品
    private StringBuffer buffer = new StringBuffer();
    //支持连缀
    public GenConfBuilder addGenConf(){
        buffer.append(GenConfEnum.GenConf);
        return this;
    }
    public GenConfBuilder addNeedGens(){
        buffer.append(GenConfEnum.NeedGens);
        return this;
    }
    public GenConfBuilder addNeedGen(){
        buffer.append(GenConfEnum.NeedGen);
        return this;
    }
    public GenConfBuilder addThemes(){
        buffer.append(GenConfEnum.Themes);
        return this;
    }
    public GenConfBuilder addTheme(){
        buffer.append(GenConfEnum.Theme);
        return this;
    }
    public GenConfBuilder addConstants(){
        buffer.append(GenConfEnum.Constants);
        return this;
    }
    public GenConfBuilder addConstant(){
        buffer.append(GenConfEnum.Constant);
        return this;
    }

    public GenConfBuilder addProvider(){
        buffer.append(GenConfEnum.provider);
        return this;
    }
    public GenConfBuilder addThemeId(){
        buffer.append(GenConfEnum.themeId);
        return this;
    }
    public GenConfBuilder addParams(){
        buffer.append(GenConfEnum.Params);
        return this;
    }
    public GenConfBuilder addParam(){
        buffer.append(GenConfEnum.Param);
        return this;
    }

    public StringBuffer getBuilderBuffer() {
        return this.buffer;
    }

    protected GenConfBuilder getBuilderClassInstance() {
        return this;
    }

}
