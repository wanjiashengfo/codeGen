package com.xgen.util.readxml;

import lombok.Data;

import java.util.*;

public class Parser2 {
    private static final String FORWAR_SLASH = "/";
    private static final String DOT = ".";
    private static final String DOLLAR = "$";

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    /**
     * 按照分解的先后顺序的元素名称
     */
    private static List<String> listEle = null;

    private Parser2() {
    }
    //////////////////备忘录部分-begin//////////////////
    @Data
    private static class MementoImpl implements ParseMemento{
        private Map<String,ReadXmlExpression> mapRe = new HashMap<String, ReadXmlExpression>();

        public MementoImpl(Map<String, ReadXmlExpression> mapRe) {
            this.mapRe = mapRe;
        }

    }
    public static ReadXmlExpression parse(String expr){
        //1.应该获取备忘录对象
        ParseMemento memento = ParseCaretaker.getInstance().retriveMemnto();

        //2.从备忘录中取出数据
        Map<String,ReadXmlExpression> mapRe = null;
        if(memento == null){
            mapRe = new HashMap<String, ReadXmlExpression>();
        }else {
            mapRe = ((MementoImpl) memento).getMapRe();
        }
        //3.从缓存里面找出最长的相同的string来，这部分就不用解析了
        String notParseExpr = searchMaxLongEquals(expr,mapRe);

        //4.得到剩下的需要解析的部分
        String needParseExpr = "";
        if(notParseExpr.trim().length() == 0){
            needParseExpr = expr;
        }else{
            if(notParseExpr.length() < expr.length()){
                needParseExpr = expr.substring(notParseExpr.length()+1);
            }else{
                needParseExpr = "";
            }
        }
        //5.真正解析剩下的需要解析的string
        if(needParseExpr.trim().length()>0){
            ReadXmlExpression re = parse2(needParseExpr);
        }
        //6.把两个部分抽象语法树合并起来
        return null;
    }

    /**
     * 最长的已经解析过的字符串
     * @param expr
     * @param mapRe
     * @return
     */
    private static String searchMaxLongEquals(String expr,Map<String,ReadXmlExpression> mapRe){
        boolean flag = mapRe.containsKey(expr);
        while (!flag){
            int lastIndex = expr.lastIndexOf(FORWAR_SLASH);
            if(lastIndex > 0){
                expr = expr.substring(0,lastIndex);
                flag = mapRe.containsKey(expr+FORWAR_SLASH);
            }else {
                expr = "";
                flag = true;
            }
        }
        return expr;
    }
    /////////////////备忘录部分-end/////////////////////
    /**
     * 根据传入的表达式，通过解析，组合成为一个抽象的语法树
     * @param expr
     * @return
     */
    private static ReadXmlExpression parse2(String expr){
        listEle = new ArrayList<String>();
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
                    setParsePath(propName,true,true,mapPath);
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
            pm.setCondition(eleName.substring(tempBegin+1,tempEnd));
            eleName = eleName.substring(0,tempBegin);
        }
            pm.setEleName(eleName);


        mapPath.put(eleName, pm);
        listEle.add(eleName);
    }

    /**
     * 根据元素对应的解析模型 转换成相应的解释器对象
     * @param mapPath
     * @return
     */
    private static List<ReadXmlExpression> mapPath2Expression(Map<String,ParseModel> mapPath){
        //一定要按照分解的先后顺序来转换成相应的解释器对象
        ArrayList<ReadXmlExpression> list = new ArrayList<ReadXmlExpression>();
        for (String key : listEle) {
            ParseModel pm = mapPath.get(key);
            ReadXmlExpression obj = parseModel2ReadXmlExpression(pm);
            list.add(obj);
        }
        return list;
    }

    private static ReadXmlExpression parseModel2ReadXmlExpression(ParseModel pm){
        ReadXmlExpression obj = null;
        if(!pm.isEnd()){
            if(pm.isSingleValue()){
                obj = new ElementExpression(pm.getEleName(),pm.getCondition());
            }else {
                obj = new ElementsExpression(pm.getEleName(),pm.getCondition());
            }
        }else {
            if(pm.isPropertyValue()){
                if(pm.isSingleValue()){
                    obj = new PropertyTerminalExpression(pm.getEleName());
                }else {
                    obj = new PropertiesTerminalExpression(pm.getEleName());
                }
            }else {
                if(pm.isSingleValue()){
                    obj = new ElementTerminalExpression(pm.getEleName(),pm.getCondition());
                }else {
                    obj = new ElementsTerminalExpression(pm.getEleName(),pm.getCondition());
                }
            }
        }
        return obj;
    }

    /**
     * 按照先后顺序组成成为抽象语法树
     * @param listExpression
     * @return
     */
    private static ReadXmlExpression buildTree(List<ReadXmlExpression> listExpression){
        //第一个对象，根对象，也就是返回去的对象
        ReadXmlExpression retRe = null;
        //用来临时记录一个元素，也就是父元素
        ReadXmlExpression preRe = null;

        for (ReadXmlExpression re : listExpression) {
            if(preRe == null){
                preRe = re;
                retRe = re;
            }else {
                //吧当前元素添加到父元素下面 同时把自己设置成父元素
                if(preRe instanceof  ElementExpression){
                    ElementExpression ele = (ElementExpression) preRe;
                    ele.addEle(re);
                    preRe = re;
                }else if(preRe instanceof  ElementsExpression){
                    ElementsExpression eles = (ElementsExpression) preRe;
                    eles.addEle(re);
                    preRe = re;
                }
            }
        }
        return retRe;
    }
}
