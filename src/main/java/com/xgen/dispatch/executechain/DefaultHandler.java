package com.xgen.dispatch.executechain;

import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.mediator.CoreMediator;

public class DefaultHandler extends GenHandler{
    /**
     * 需要生成的标志
     */
    private String needGenType = "";

    public DefaultHandler(String needGenType){
        this.needGenType = needGenType;
    }
    public void handleRequest(ModuleConfModel mcm){
        //1.继续调用真正实现生成功能的模块
        CoreMediator.getInstance().needProxyGen();
        //2.交给父类 继续职责链的后续处理
    }
}
