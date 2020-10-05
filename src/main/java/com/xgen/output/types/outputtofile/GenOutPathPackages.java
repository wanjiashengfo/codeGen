package com.xgen.output.types.outputtofile;

import com.xgen.genconf.vo.ModuleConfModel;

public interface GenOutPathPackages {
    /**
     * 根据配置来生成内容输出的文件夹
     * @param moduleConf
     * @param genTypeId
     * @return
     */
    public boolean genPackages(ModuleConfModel moduleConf,String genTypeId);

    /**
     * 获取内容输出到的文件的全路径名
     * @return
     */
    public String getOutPathAndFileName(ModuleConfModel moduleConf,String genTypeId);
}
