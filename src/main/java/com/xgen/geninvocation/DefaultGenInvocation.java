package com.xgen.geninvocation;

import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.geninvocation.state.DefaultBeginState;
import com.xgen.geninvocation.state.State;
import lombok.Getter;
import lombok.Setter;

public class DefaultGenInvocation implements GenInvocation{
    /**
     * 持有一个状态对象
     */
    @Setter
    private State state = null;
    /**
     * 具体要生成的类型标志
     */
    @Getter
    private String needGenType = "";
    /**
     * 当前被生成的模块的数据
     */
    @Getter
    private ModuleConfModel moduleConf;

    public DefaultGenInvocation(String needGenType,ModuleConfModel moduleConf){
        this.needGenType = needGenType;
        this.moduleConf = moduleConf;
    }

    /**
     * 执行工作 在每一个state完成自己的工作之后调用
     */
    public void doWork(){
        this.state.doWork(this);
    }
    @Override
    public void executeGen() {
        //设置generate调用流程开始需要执行的状态
        state = new DefaultBeginState();
        //让状态执行工作
        state.doWork(this);
        //第一大步：调用相应的生成实现来获取生成的内容

        //第二大步：把生成的内容输出出去
    }
}
