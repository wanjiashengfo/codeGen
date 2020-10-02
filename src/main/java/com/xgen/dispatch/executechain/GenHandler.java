package com.xgen.dispatch.executechain;

import com.xgen.genconf.vo.ModuleConfModel;
import lombok.Setter;

public abstract class GenHandler {
    /**
     * 持有后继的指责对象
     */
    @Setter
    protected GenHandler successor;

    /**
     * 缺省实现处理请求的方法
     * @param mcm
     */
    public void handleRequest(ModuleConfModel mcm){
        //如果不属于自己的职责范围 那就判断是否还有后继的职责对象
        //如果有 就转发请求给后继的职责对象
        if (this.successor!=null){
            this.successor.handleRequest(mcm);
        }
    }

}
