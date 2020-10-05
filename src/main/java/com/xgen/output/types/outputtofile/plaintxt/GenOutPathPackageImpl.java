package com.xgen.output.types.outputtofile.plaintxt;

import com.xgen.genconf.constants.ExpressionEnum;
import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.mediator.CoreMediator;
import com.xgen.output.types.outputtofile.GenOutPathPackages;
import com.xgen.util.file.FileHelper;

import java.util.Map;

public class GenOutPathPackageImpl implements GenOutPathPackages {
    @Override
    public boolean genPackages(ModuleConfModel moduleConf, String genTypeId) {
        FileHelper.genDir(this.getDirPath(moduleConf,genTypeId));
        return false;
    }
    private String getDirPath(ModuleConfModel moduleConf, String genTypeId){
        String codeOutPath = moduleConf.getMapExtends().get("codeOutPath").getValue();
        String relativePath = CoreMediator.getInstance().getGenTypeParams(moduleConf,genTypeId).get("relativePath");
        Map<String, ExtendConfModel> mapExtends = moduleConf.getMapExtends();
        ExtendConfModel modulePackage = mapExtends.get("modulePackage");
        String packagePath = ""+moduleConf.getMapExtends().get("modulePackage").getValue();
        String dirPackages = codeOutPath+ExpressionEnum.dot.getExpr()+
                packagePath + ExpressionEnum.dot.getExpr()+relativePath;
        String packages = dirPackages.replace(ExpressionEnum.dot.getExpr(),ExpressionEnum.separator.getExpr());
        return packages;
    }
    @Override
    public String getOutPathAndFileName(ModuleConfModel moduleConf, String genTypeId) {
        String preName = CoreMediator.getInstance().getGenTypeParams(moduleConf,genTypeId).get("preGenFileName");
        String afterName = CoreMediator.getInstance().getGenTypeParams(moduleConf,genTypeId).get("afterGenFileName");

        String moduleNameSuperCase = moduleConf.getMapExtends().get("moduleNameSuperCase").getValue();
        String retName = this.getDirPath(moduleConf,genTypeId)
                +ExpressionEnum.separator.getExpr()
                +preName+moduleNameSuperCase+afterName;
        return retName;
    }
}
