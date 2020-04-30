package com.xgen.util.readxml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Parser {
    private static final String FORWAR_SLASH = "/";
    private static final String DOT = ".";
    private static final String DOLLAR = "$";

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";


    private Parser() {
    }

    /**
     * 根据传入的表达式，通过解析，组合成为一个抽象的语法树
     * @param expr
     * @return
     */
    public static ReadXmlExpression parse(String expr){

        //1.分解表达式，得到需要解析的元素名称和该元素对应的解析模型
        Map<String, ParseModel> mapPath = parseMapPath(expr);
        //2根据元素对应的解析模型 转换成相应的解释器对象
        List<ReadXmlExpression> list = mapPath2Expression(mapPath);
        //3按照先后顺序组成成为抽象语法树
        ReadXmlExpression retTree  = buildTree(list);
        return retTree;
    }

    /**
     * 按照从左到右的顺序来解析表达式 得到相应的元素名称和该元素对应的解析模型
     * @param expr
     * @return
     */
    private static Map<String,ParseModel> parseMapPath(String expr){
        Map<String,ParseModel> mapPath = new HashMap<String, ParseModel>();
          //root/a/b/c.name
        StringTokenizer tokenizer = new StringTokenizer(expr,FORWAR_SLASH);
        while (tokenizer.hasMoreTokens()){
            String onePath = tokenizer.nextToken();
            if(tokenizer.hasMoreTokens()){
                //还有下一个，说明不是结尾
                setParsePath(onePath,false, false,mapPath);
            }else {
                //说明到结尾了
                int dotIndex = onePath.indexOf(DOT);
                if(dotIndex > 0){
                    //属性结尾
                    String eleName = onePath.substring(0,dotIndex);
                    String propName = onePath.substring(dotIndex+1);
                    //设置属性前面的元素
                    setParsePath(eleName,false,false,mapPath);
                    //设置属性
                    setParsePath(propName,true,false,mapPath);
                }else {
                    //元素结尾
                    setParsePath(onePath,true ,false, mapPath);
                }
                //已经解析到结尾，退出
                break;
            }
        }
        return mapPath;
    }

    private static void setParsePath(String eleName, boolean end,boolean propertyValue, Map<String, ParseModel> mapPath) {

        ParseModel pm = new ParseModel();
        pm.setEnd(end);
        pm.setPropertyValue(propertyValue);
        pm.setSingleValue(!(eleName.indexOf(DOLLAR) > 0));
        //去掉$
        eleName = eleName.replace(DOLLAR,"");

        int tempBegin = 0;
        int tempEnd = 0;

        if((tempBegin = eleName.indexOf(OPEN_BRACKET))>0){
            tempEnd = eleName.indexOf(CLOSE_BRACKET);
            pm.setCondition(eleName.substring(tempBegin,tempEnd));
            eleName = eleName.substring(0,tempBegin);
        }else {
            pm.setEleName(eleName);
        }

        mapPath.put(eleName, pm);
    }

    /**
     * 根据元素对应的解析模型 转换成相应的解释器对象
     * @param mapPath
     * @return
     */
    private static List<ReadXmlExpression> mapPath2Expression(Map<String,ParseModel> mapPath){
        return null;
    }

    /**
     * 按照先后顺序组成成为抽象语法树
     * @param listExpression
     * @return
     */
    private static ReadXmlExpression buildTree(List<ReadXmlExpression> listExpression){
        return null;
    }
}
