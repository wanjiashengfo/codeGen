package com.xgen.genconf.implementors.dynamicparse;

import com.xgen.genconf.vo.ExtendConfModel;
import com.xgen.genconf.vo.GenConfModel;

import java.util.Map;

public class ParseContext {
    public Map<String, ExtendConfModel> parse(GenConfModel gm, Map<String,ExtendConfModel> mapEcms){
        //如果${}里面是一个单独的单词 那就使用属性直接替换否则使用beanshell
        for (String key : mapEcms.keySet()) {
            ExtendConfModel ecm = mapEcms.get(key);
            ecm.setValue(this.parseOne(gm,mapEcms,ecm.getValue()));
            mapEcms.put(key,ecm);
        }
        return mapEcms;
    }

    private String parseOne(GenConfModel gm,Map<String,ExtendConfModel> mapEcms,String value){
        //首先判断是否有${} 如果没有 就不用解析
        if(value != null&&value.indexOf("${") >= 0){
            //如果有${}那么把里面的值取出来 再判断
            int begin = value.indexOf("${");
            int end = begin + "${".length()+value.substring(begin+"${".length()).indexOf("}");
            String prop = value.substring(begin+"${".length(),end);
            //再判断${}里面是一个单独的单词 那就使用属性直接替换 否则使用beanshell
            ParseStrategy ps = null;
            if(isWord(prop)){
                ps = new PropertyReplaceStrategy();
            }else {
                ps = new BeanShellStrategy();
            }
            String tempStr = ps.parseDynamicContent(gm, mapEcms, prop);
            //然后把这动态的部分数据替换回到value上
            value = value.replace("${"+prop+"}",tempStr);
            //继续递归
            value = parseOne(gm,mapEcms ,value);
        }
        return value;
    }

    private boolean isWord(String s){
        char cs[] = s.toCharArray();
        for (char c : cs) {
            if((c>='a' && c<='z')||(c>='A' && c<='Z')){
            //全是字母
            }else {
                return false;
            }
        }
        return true;
    }
}
