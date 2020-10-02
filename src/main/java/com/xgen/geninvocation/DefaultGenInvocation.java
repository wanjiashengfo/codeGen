package com.xgen.geninvocation;

import com.xgen.genconf.vo.ModuleConfModel;

public class DefaultGenInvocation implements GenInvocation{
    /**
     * 具体要生成的类型标志
     */
    private String needGenType = "";
    /**
     * 当前被生成的模块的数据
     */
    private ModuleConfModel moduleConf;

    public DefaultGenInvocation(String needGenType,ModuleConfModel moduleConf){
        this.needGenType = needGenType;
        this.moduleConf = moduleConf;
    }
    @Override
    public void executeGen() {
        //第一大步：调用相应的生成实现来获取生成的内容

        //第二大步：把生成的内容输出出去
    }
}
