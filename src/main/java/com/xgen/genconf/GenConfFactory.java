package com.xgen.genconf;

import com.xgen.genconf.implementors.GenConfImplementor;

public class GenConfFactory {
    private GenConfFactory() {
    }

    public static GenConfEbi createGernConfEbi (GenConfImplementor provider){
        return  GenConfEbo.getInstance(provider);
    }

    /**
     * 创建访问核心配置的接口对象 前提是确保已经获取了配置数据 这个方法才能正确执行
     * @return
     */
    public static GenConfEbi createGernConfEbi (){
        return  createGernConfEbi(null);
    }
}
