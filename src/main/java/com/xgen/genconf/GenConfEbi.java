package com.xgen.genconf;

import com.xgen.genconf.vo.GenConfModel;

public interface GenConfEbi {
    /**
     * 获取x-gen核心框架运行所需要的配置数据model
     * @return
     */
    public GenConfModel getGenConf();
}
