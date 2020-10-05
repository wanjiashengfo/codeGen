package com.xgen.output.types.outputtofile;

import com.xgen.genconf.vo.ModuleConfModel;

public interface Outter {
    public boolean writeContent(String outPathAndFileName,String content);
}
