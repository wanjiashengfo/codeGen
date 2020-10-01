package com.xgen.dispatch.command;

import lombok.Setter;

public class CmdInvoker {
    /**
     * 持有的命令对象
     */
    @Setter
    private  GenCommand cmd = null;

    /**
     * 提供给客户端使用的方法
     */
    public void doCommand(){
        this.cmd.execute();
    }
}
