package com.xgen.output.types;

import com.xgen.mediator.CoreMediator;
import com.xgen.output.GenOutputEbi;
import com.xgen.output.types.outputtofile.AbstractFactory;
import com.xgen.output.types.outputtofile.plaintxt.PlainTxtFactory;

import java.util.Observable;

public class OutputToFile implements GenOutputEbi {
    @Override
    public void update(Observable o, Object obj) {
        //1.首先得到要输出的内容
        String content = ""+obj;
        //2.根据配置 创建输出文件的文件夹
        AbstractFactory af = new PlainTxtFactory();
        af.createGenOutPathPackages().genPackages(CoreMediator.getInstance().getObserverModuleConf(o),
                CoreMediator.getInstance().getObserverGenTypeId(o));
        //3.输出成文件到这个文件夹中去
        //3.1得到文件的路径和文件名
        String outFilePathAndName = af.createGenOutPathPackages().getOutPathAndFileName(CoreMediator.getInstance().getObserverModuleConf(o),
                CoreMediator.getInstance().getObserverGenTypeId(o));
        //3.2使用outter对象输出
        af.createOutter().writeContent(outFilePathAndName,content);
        System.out.println("now to file");
    }
}
