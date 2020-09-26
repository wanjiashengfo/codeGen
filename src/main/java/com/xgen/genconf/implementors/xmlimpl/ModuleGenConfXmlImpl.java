package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.implementors.ModuleGenConfImplementor;
import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.ModuleConfModel;

import java.util.List;
import java.util.Map;

public class ModuleGenConfXmlImpl implements ModuleGenConfImplementor {
    public ModuleConfModel getBaseModuleConfModel(Map<String, String> params) {
        return null;
    }

    public Map<String, List<String>> getMapNeedGenTypes(Map<String, String> params) {
        return null;
    }

    public Map<String, ExtendConfModel> getMapExtends(Map<String, String> params) {
        return null;
    }
}
