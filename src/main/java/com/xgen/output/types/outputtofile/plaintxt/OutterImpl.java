package com.xgen.output.types.outputtofile.plaintxt;

import com.xgen.output.types.outputtofile.Outter;
import com.xgen.util.file.FileHelper;

public class OutterImpl implements Outter {
    @Override
    public boolean writeContent(String outPathAndFileName, String content) {
        FileHelper.writeFile(outPathAndFileName,content);
        return true;
    }
}
