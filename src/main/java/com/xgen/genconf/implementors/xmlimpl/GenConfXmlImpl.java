package com.xgen.genconf.implementors.xmlimpl;

import com.xgen.genconf.implementors.GenConfImplementor;
import com.xgen.genconf.vo.NeedGenModel;
import com.xgen.genconf.vo.ThemeModel;

import java.util.List;
import java.util.Map;

public class GenConfXmlImpl implements GenConfImplementor {
    //1.通过builder来获取用于取值的字符串
    //2.使用这些字符串，通过parser去获取到配置的数据，
    //3.然后把这些数据组装成GenConfImplementor所需要的的样子
    public List<NeedGenModel> getNeedGens() {
        return null;
    }

    public List<ThemeModel> getThemes() {
        return null;
    }

    public Map<String, String> getMapConstants() {
        return null;
    }


}
