package com.xgen.dispatch.command;

import com.xgen.genconf.vo.ModuleConfModel;

public class DefaultCommand implements GenCommand {
    /**
     * 具体要生成的模块的配置
     */
    private ModuleConfModel moduleConf;

    public DefaultCommand(ModuleConfModel moduleConf){
        this.moduleConf = moduleConf;
    }
    @Override
    public void execute() {
        //  应该调用后续的模块去实现真正的功能

    }
}
